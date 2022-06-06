package com.zenithbank.integration.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.zenithbank.integration.config.exception.ApiException;
import com.zenithbank.integration.dto.*;
import com.zenithbank.integration.entity.enumeration.Partners;
import com.zenithbank.integration.entity.flight.CorePartners;
import com.zenithbank.integration.entity.flight.CoreUser;
import com.zenithbank.integration.entity.flight.QCoreBookingDetails;
import com.zenithbank.integration.externalintegratiion.wakanow.pojo.BookingFlightResponse;
import com.zenithbank.integration.externalintegratiion.wakanow.pojo.FlightSerchResponse;
import com.zenithbank.integration.externalintegratiion.wakanow.pojo.SelectFlightResponse;
import com.zenithbank.integration.dto.response.BookFlightResponseD;
import com.zenithbank.integration.dto.response.FlightSearchResponse;
import com.zenithbank.integration.dto.response.FlightTicketResponseD;
import com.zenithbank.integration.dto.response.SelectFlightResponseD;
import com.zenithbank.integration.entity.flight.CoreBookingDetails;
import com.zenithbank.integration.externalintegratiion.wakanow.pojo.FlightTicketResponse;
import com.zenithbank.integration.services.CoreBookingDetailsService;
import com.zenithbank.integration.services.CorePartnerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IntegrationService {
    WakanowRegistratioService wakanowService;
    EntityManager entityManager;
    CorePartnerService corePartnerService;
    CoreBookingDetailsService coreBookingDetailsService;

    public IntegrationService(WakanowRegistratioService service, EntityManager entityManager,
                              CorePartnerService corePartnerService,
                              CoreBookingDetailsService coreBookingDetailsService) {
        this.wakanowService = service;
        this.entityManager = entityManager;
        this.corePartnerService = corePartnerService;
        this.coreBookingDetailsService = coreBookingDetailsService;
    }

    public List<FlightSearchResponse> searchForFlight(SearchRequestDto request){
        Page<CorePartners> partnersPg = corePartnerService.findAll(Pageable.unpaged());

        List<CorePartners> partners = partnersPg.getContent();

        List<FlightSearchResponse> responses = new ArrayList<>();

        partners.stream().forEach(partner -> {
            List<FlightSearchResponse> result = new ArrayList<>();

            if(partner.getPartnerName().equalsIgnoreCase(Partners.WAKANOW.getValue())){
                List<FlightSerchResponse> res = wakanowService.searchForFlightOnWakanow(request);

                result = res.parallelStream().map(waka -> {
                    FlightSearchResponse response = new FlightSearchResponse();

                    response = wakanowService.mapperSearch(waka);
                    response.setPartnerId(partner.getId());

                    return response;
                }).collect(Collectors.toList());

                responses.addAll(result);
            }
        });

        return responses;
    }

    public SelectFlightResponseD selectFlight(SelectRequestDto selectRequestDto){
        Optional<CorePartners> partnersPg = corePartnerService.findById(selectRequestDto.getPartnerId());

        CorePartners partners = partnersPg.orElseThrow(() -> new ApiException("Specified Partner does not exist"));

        if(partners.getPartnerName().equalsIgnoreCase(Partners.WAKANOW.getValue())){
            SelectFlightResponse res = wakanowService.getSelectedFlight(selectRequestDto);
;
            SelectFlightResponseD response = wakanowService.mapperSelectFlight(res);

            response.setPartnerId(partners.getId());

            return response;
        }

        return null;
    }

    @Transactional
    public BookFlightResponseD bookFlight(BookFlightDto bookDto, CoreUser user){
        Optional<CorePartners> partnersPg = corePartnerService.findById(bookDto.getPartnerId());

        QCoreBookingDetails qCoreBookingDetails = QCoreBookingDetails.coreBookingDetails;

        CorePartners partners = partnersPg.orElseThrow(() -> new ApiException("Specified Partner does not exist"));

        //insert into bookingDetails
        List<Long> coreBookingDetails = bookingMapper(bookDto, partners.getPartnerName(), user);
        try {
            if(partners.getPartnerName().equalsIgnoreCase(Partners.WAKANOW.getValue())){
                BookingFlightResponse res = wakanowService.bookingFlightResponse(bookDto);

                BookFlightResponseD response = wakanowService.mapBooking(res);

                response.setPartnerId(partners.getId());

                JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

                JPAUpdateClause updateClause = jpaQueryFactory.update(qCoreBookingDetails)
                        .set(qCoreBookingDetails.status, "PROCESSED")
                        .where(qCoreBookingDetails.id.in(coreBookingDetails));

                updateClause.execute();

                return response;
            }
        }catch (Exception ex){
            JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

            JPAUpdateClause updateClause = jpaQueryFactory.update(qCoreBookingDetails)
                    .set(qCoreBookingDetails.status, "PENDING")
                    .where(qCoreBookingDetails.id.in(coreBookingDetails));

            updateClause.execute();

            throw new ApiException("Failed booking with reason: " + ex.getMessage());

        }


        return null;
    }

    public FlightTicketResponseD getFlightTicket(FlightTicketDto flightTicketDto){
        Optional<CorePartners> partnersPg = corePartnerService.findById(flightTicketDto.getPartnerId());

        CorePartners partners = partnersPg.orElseThrow(() -> new ApiException("Specified Partner does not exist"));

        if(partners.getPartnerName().equalsIgnoreCase(Partners.WAKANOW.getValue())){
            FlightTicketResponse res = wakanowService.getFlightTicket(flightTicketDto);

            FlightTicketResponseD response = wakanowService.mapTickets(res);

            response.setPartnerId(partners.getId());

            return response;
        }

        return null;
    }


    private List<Long> bookingMapper(BookFlightDto bookingDtos, String partnerName, CoreUser user){
        List<Long> details = new ArrayList<>();

        for(PassengerDetailsDto p: bookingDtos.getPassengerDetails()) {
            CoreBookingDetails coreBookingDetails = new CoreBookingDetails();

            coreBookingDetails.setBookingId(bookingDtos.getBookingId());
            coreBookingDetails.setBookingData(bookingDtos.getBookingItemModels().get(0).getBookingData());
            coreBookingDetails.setBookingReference("");
            coreBookingDetails.setAddress(p.getAddress());
            coreBookingDetails.setCountry(p.getCountry());
            coreBookingDetails.setCity(p.getCity());
            coreBookingDetails.setCountryCode(p.getCountryCode());
            coreBookingDetails.setAccountNo(bookingDtos.getAccountNo());
            coreBookingDetails.setEmail(p.getEmail());
            coreBookingDetails.setGender(p.getGender());
            coreBookingDetails.setExpiryDate(p.getExpiryDate());
            coreBookingDetails.setCreatedDt(new Date());
            coreBookingDetails.setCreatedBy(user.getUserName());
            coreBookingDetails.setDateOfBirth(p.getDateOfBirth());
            coreBookingDetails.setFirstName(p.getFirstName());
            coreBookingDetails.setLastName(p.getLastName());
            coreBookingDetails.setMiddleName(p.getMiddleName());
            coreBookingDetails.setPartnerId(bookingDtos.getPartnerId());
            coreBookingDetails.setPartnerName(partnerName);
            coreBookingDetails.setPassengerType(p.getPassengerType());
            coreBookingDetails.setPassportIssuingAuthority(p.getPassportIssuingAuthority());
            coreBookingDetails.setPassportNumber(p.getPassportNumber());
            coreBookingDetails.setPhoneNumber(p.getPhoneNumber());
            coreBookingDetails.setPostalCode(p.getPostalCode());
            coreBookingDetails.setPostingReference(bookingDtos.getPostingRef());
            coreBookingDetails.setProductType("");
            coreBookingDetails.setStatus("PROCESSING");
            coreBookingDetails.setTargetCurrency("");
            coreBookingDetails.setTitle(p.getTitle());

            coreBookingDetails = coreBookingDetailsService.saveOrUpdate(coreBookingDetails);

            details.add(coreBookingDetails.getId());
        }

        return details;
    }
}
