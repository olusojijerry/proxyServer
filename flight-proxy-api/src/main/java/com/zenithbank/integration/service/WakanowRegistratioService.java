package com.zenithbank.integration.service;

import com.zenithbank.integration.externalintegratiion.wakanow.pojo.*;
import com.zenithbank.integration.externalintegratiion.wakanow.requestPojo.*;
import com.zenithbank.integration.externalintegratiion.feign.client.WakanowClient;
import com.zenithbank.integration.dto.*;
import com.zenithbank.integration.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WakanowRegistratioService {
    @Autowired
    WakanowClient wakanowClient;

    private SearchRequestWakanow searchRequestMapper(SearchRequestDto request){
        SearchRequestWakanow requestWakanow = new SearchRequestWakanow();

        requestWakanow.setAdults(request.getAdults());
        requestWakanow.setChildren(request.getChildren());
        requestWakanow.setFlightSearchType(request.getFlightSearchType());
        requestWakanow.setInfants(request.getInfants());
        requestWakanow.setTicketclass(request.getTicketclass());
        requestWakanow.setTargetCurrency(request.getTargetCurrency());

        List<ItineraryWakanow> lst = new ArrayList<>();

        for(ItineraryDto i : request.getItineraries()){
            ItineraryWakanow waka = new ItineraryWakanow();

            waka.setDeparture(i.getDeparture());
            waka.setDestination(i.getDestination());
            waka.setDepartureDate(i.getDepartureDate());

            lst.add(waka);
        }

        requestWakanow.setItineraries(lst);

        return requestWakanow;
    }

    private SelectRequest selectRequestMapper(SelectRequestDto selectRequestDto){
        SelectRequest selectRequest = new SelectRequest();

        selectRequest.setSelectData(selectRequestDto.getSelectData());
        selectRequest.setTargetCurrency(selectRequestDto.getTargetCurrency());

        return selectRequest;
    }

    public List<FlightSerchResponse> searchForFlightOnWakanow(SearchRequestDto request){
        SearchRequestWakanow requestWakanow = searchRequestMapper(request);

        List<FlightSerchResponse> response = wakanowClient.searchForFlight(requestWakanow);

        return response;
    }

    public SelectFlightResponse getSelectedFlight(SelectRequestDto requestDto){
        SelectRequest req = selectRequestMapper(requestDto);

        return wakanowClient.selectFlight(req);
    }

    public HttpEntity<byte[]> downloadAirports(){
        return wakanowClient.getAirports();
    }

    public BookingFlightResponse bookingFlightResponse(BookFlightDto bookFlightDto){
        BookFlightRequest request = bookFlight(bookFlightDto);

        BookingFlightResponse response = wakanowClient.bookFlight(request);

        return response;
    }

    public FlightTicketResponse getFlightTicket(FlightTicketDto ticketDto){
        FlightTicketRequest request = mapperFlightTicket(ticketDto);

        FlightTicketResponse response = wakanowClient.flightTicket(request);

        return response;
    }

    private FlightTicketRequest mapperFlightTicket(FlightTicketDto ticketDto){
        FlightTicketRequest req = new FlightTicketRequest();

        req.setBookingId(ticketDto.getBookingId());
        req.setPnrNumber(ticketDto.getPnrNumber());

        return req;
    }

    private BookFlightRequest bookFlight(BookFlightDto request){
        BookFlightRequest book = new BookFlightRequest();

        book.setBookingId(request.getBookingId());

        List<PassengerDetails> passengerDetails = new ArrayList<>();

        for(PassengerDetailsDto pass : request.getPassengerDetails()){
            PassengerDetails pg = new PassengerDetails();
            pg.setAddress(pass.getAddress());
            pg.setCity(pass.getCity());
            pg.setCountry(pass.getCountry());
            pg.setCountryCode(pass.getCountryCode());
            pg.setDateOfBirth(pass.getDateOfBirth());
            pg.setEmail(pass.getEmail());
            pg.setExpiryDate(pass.getExpiryDate());
            pg.setGender(pass.getGender());
            pg.setFirstName(pass.getFirstName());
            pg.setLastName(pass.getLastName());
            pg.setMiddleName(pass.getMiddleName());
            pg.setPassengerType(pass.getPassengerType());
            pg.setPassportIssuingAuthority(pass.getPassportIssuingAuthority());
            pg.setPassportNumber(pass.getPassportNumber());
            pg.setPhoneNumber(pass.getPhoneNumber());
            pg.setPostalCode(pass.getPostalCode());
            pg.setTitle(pass.getTitle());

            passengerDetails.add(pg);
        }

        List<BookingItemModels> bks = new ArrayList<>();

        for(BookingItemModelsDto itemModels: request.getBookingItemModels()){
            BookingItemModels item = new BookingItemModels();

            item.setBookingId(itemModels.getBookingId());
            item.setTargetCurrency(itemModels.getTargetCurrency());
            item.setBookingData(itemModels.getBookingData());
            item.setProductType(itemModels.getProductType());

            bks.add(item);
        }

        book.setBookingItemModels(bks);
        book.setPassengerDetails(passengerDetails);

        return book;
    }

    private FlightCombinationD mapCombination(FlightCombination res){
        FlightCombinationD combinationD = new FlightCombinationD();

        combinationD.setFareRules(res.getFareRules());
        combinationD.setPaySmallSmallLockDownPrice(res.getPaySmallSmallLockDownPrice());
        combinationD.setNonRefundableFreeText(res.getNonRefundableFreeText());
        combinationD.setIncludePaySmallSmall(res.getIncludePaySmallSmall());
        combinationD.setConnectionCode(res.getConnectionCode());
        combinationD.setInfants(res.getInfants());
        combinationD.setChildren(res.getChildren());
        combinationD.setAdults(res.getAdults());
        combinationD.setIsRefundable(res.getIsRefundable());
        combinationD.setNonRefundableFreeText(res.getNonRefundableFreeText());
        combinationD.setPenaltyRules(res.getPenaltyRules());
        combinationD.setMarketingCarrier(res.getMarketingCarrier());
        combinationD.setDownloadPaymentDetailInPercentage(res.getDownloadPaymentDetailInPercentage());
        combinationD.setAirlineCode(res.getAirlineCode());
        combinationD.setFlightModels(res.getFlightModels().parallelStream().map(models -> modelsMapper(models))
                .collect(Collectors.toList()));
        PriceD price = new PriceD();

        price.setCurrencyCode(res.getPrice().getCurrencyCode());
        price.setAmount(res.getPrice().getAmount());
        combinationD.setPrice(price);

        return combinationD;
    }

    public FlightModelsD modelsMapper(FlightModels f){
        FlightModelsD modelsD = new FlightModelsD();

        modelsD.setAirline(f.getAirline());
        modelsD.setAirlineLogoUrl(f.getAirlineLogoUrl());
        modelsD.setAirline(f.getAirline());
        modelsD.setArrivalCode(f.getArrivalCode());
        modelsD.setAirlineName(f.getAirlineName());
        modelsD.setArrivalName(f.getArrivalName());
        modelsD.setArrivalTime(f.getArrivalTime());
        modelsD.setDepartureCode(f.getDepartureCode());
        modelsD.setDepartureName(f.getDepartureName());
        modelsD.setDepartureTime(f.getDepartureTime());
        modelsD.setName(f.getName());
        modelsD.setStopCity(f.getStopCity());
        modelsD.setStops(f.getStops());
        modelsD.setStopTime(f.getStopTime());
        modelsD.setTripDuration(f.getTripDuration());

        FreeBaggageD baggageD = new FreeBaggageD();

        baggageD.setBagCount(f.getFreeBaggage().getBagCount());
        baggageD.setBagWeight(f.getFreeBaggage().getBagWeight());
        baggageD.setWeightUnit(f.getFreeBaggage().getWeightUnit());

        modelsD.setFreeBaggage(baggageD);

        modelsD.setFlightLegs(f.getFlightLegs().parallelStream().map(leg ->{
            FlightLegD flightLegD = new FlightLegD();

            flightLegD.setAircraft(leg.getAircraft());
            flightLegD.setDepartureCode(leg.getDepartureCode());
            flightLegD.setFlightLegNumber(leg.getFlightLegNumber());
            flightLegD.setDepartureName(leg.getDepartureName());
            flightLegD.setDepartureCode(leg.getDepartureCode());
            flightLegD.setCabinClass(leg.getCabinClass());
            flightLegD.setCabinClassName(leg.getCabinClassName());
            flightLegD.setBookingClass(leg.getBookingClass());
            flightLegD.setCorporateCode(leg.getCorporateCode());
            flightLegD.setDestinationCode(leg.getDestinationCode());
            flightLegD.setDestinationName(leg.getDestinationName());
            flightLegD.setAircraft(leg.getAircraft());
            flightLegD.setDuration(leg.getDuration());
            flightLegD.setEndTime(leg.getEndTime());
            flightLegD.setFareBasisCode(leg.getFareBasisCode());
            flightLegD.setFareType(leg.getFareType());
            flightLegD.setFightNumber(leg.getFightNumber());
            flightLegD.setFlightSelectData(leg.getFlightSelectData());
            flightLegD.setIsStop(leg.getIsStop());
            flightLegD.setBookingClass(leg.getBookingClass());
            flightLegD.setLayOver(leg.getLayOver());
            flightLegD.setLayOverDuration(leg.getLayOverDuration());
            flightLegD.setMarketingCarrier(leg.getMarketingCarrier());
            flightLegD.setOperatingCarrier(leg.getOperatingCarrier());
            flightLegD.setSeats(leg.getSeats());
            flightLegD.setStartTime(leg.getStartTime());
            flightLegD.setStatus(leg.getStatus());
            flightLegD.setTechnicalStops(leg.getTechnicalStops());

            return flightLegD;
        }).collect(Collectors.toList()));

        return modelsD;
    }
    public FlightSearchResponse mapperSearch(FlightSerchResponse res){
        FlightSearchResponse response = new FlightSearchResponse();

        response.setSelectData(res.getSelectData());
        response.setFlightCombination(mapCombination(res.getFlightCombination()));

        return response;
    }

    public SelectFlightResponseD mapperSelectFlight(SelectFlightResponse res){
        SelectFlightResponseD responseD = new SelectFlightResponseD();

        responseD.setBookingId(res.getBookingId());
        responseD.setSelectData(res.getSelectData());
        responseD.setHasResult(res.getHasResult());
        responseD.setIsPassportRequired(res.getIsPassportRequired());
        responseD.setIsPriceMatched(res.getIsPriceMatched());
        responseD.setCustomMessages(res.getCustomMessages().parallelStream().map(msg -> customMsgMapper(msg))
                .collect(Collectors.toList()));
        responseD.setProductTermsAndConditions(mapTermsAndConditions(res.getProductTermsAndConditions()));
        responseD.setFlightSummaryModel(summaryMapper(res.getFlightSummaryModel()));

        return responseD;
    }

    private CustomMessagesD customMsgMapper(CustomMessages msg){
        CustomMessagesD custom = new CustomMessagesD();

        custom.setMessage(msg.getMessage());
        custom.setTitle(msg.getTitle());
        custom.setSecurityLevel(msg.getSecurityLevel());

        return custom;
    }

    private PriceD priceMapper(Price p){
        PriceD price = new PriceD();

        price.setAmount(p.getAmount());
        price.setCurrencyCode(p.getCurrencyCode());

        return price;
    }

    private FlightSummaryModelD summaryMapper(FlightSummaryModel sum){
        FlightSummaryModelD summaryModelD = new FlightSummaryModelD();

        summaryModelD.setFlightCombination(mapCombination(sum.getFlightCombination()));
        summaryModelD.setPriceBreakUps(sum.getPriceBreakUps());

        return summaryModelD;
    }

    private ProductTermsAndConditionsD mapTermsAndConditions(ProductTermsAndConditions cond){
        ProductTermsAndConditionsD conditionsD = new ProductTermsAndConditionsD();

        conditionsD.setTermsAndConditions(cond.getTermsAndConditions());
        conditionsD.setTermsAndConditionImportantNotice(cond.getTermsAndConditionImportantNotice());

        return conditionsD;
    }

    private FlightBookingResultD mapFlightBookingResult(FlightBookingResult result){
        FlightBookingResultD resultD = new FlightBookingResultD();

        resultD.setHasResult(result.getHasResult());
        resultD.setIsFareHigh(result.getIsFareHigh());
        resultD.setIsFareLow(result.getIsFareLow());
        resultD.setFlightBookingSummaryModel(mapBookSummaryModel(result.getFlightBookingSummaryModel()));

        return resultD;
    }

    private FlightBookingSummaryModelD mapBookSummaryModel(FlightBookingSummaryModel model){
        FlightBookingSummaryModelD sum = new FlightBookingSummaryModelD();

        sum.setPnrDate(model.getPnrDate());
        sum.setPnrReferenceNumber(model.getPnrReferenceNumber());
        sum.setPnrStatus(model.getPnrStatus());
        sum.setTicketStatus(model.getTicketStatus());
        sum.setPnrReferenceNumber(model.getPnrReferenceNumber());
        sum.setFlightSummaryModel(summaryMapper(model.getFlightSummaryModel()));
        sum.setTravellerDetails(model.getTravellerDetails().stream().map(this::mapTravellerDetails)
                .collect(Collectors.toList()));

        return sum;
    }

    private TermsAndConditionsD mapTerms(TermsAndConditions terms){
        TermsAndConditionsD cond = new TermsAndConditionsD();

        cond.setTermsAndConditions(terms.getTermsAndConditions());
        cond.setTermsAndConditionImportantNotice(terms.getTermsAndConditionImportantNotice());

        return cond;
    }

    private TravellerDetailsD mapTravellerDetails(TravellerDetails details){
        TravellerDetailsD res = new TravellerDetailsD();

        res.setAddress(details.getAddress());
        res.setCity(details.getCity());
        res.setCountry(details.getCountry());
        res.setCountryCode(details.getCountryCode());
        res.setEmail(details.getEmail());
        res.setGender(details.getGender());
        res.setExpiryDate(details.getExpiryDate());
        res.setFirstName(details.getFirstName());
        res.setDateOfBirth(details.getDateOfBirth());
        res.setAge(details.getAge());
        res.setIsWakapointRegister(details.getIsWakapointRegister());
        res.setPassengerReferenceNumber(details.getPassengerReferenceNumber());
        res.setMiddleName(details.getMiddleName());
        res.setPassengerType(details.getPassengerType());
        res.setPassportIssueCountryCode(details.getPassportIssueCountryCode());
        res.setPassportIssuingAuthority(details.getPassportIssuingAuthority());
        res.setPhoneNumber(details.getPhoneNumber());
        res.setLastName(details.getLastName());
        res.setPostalCode(details.getPostalCode());
        res.setRoomNumber(details.getRoomNumber());
        res.setSelectedBaggages(details.getSelectedBaggages());
        res.setSelectedSeats(details.getSelectedSeats());
        res.setTicketNumber(details.getTicketNumber());
        res.setTitle(details.getTitle());
        res.setWakaPointId(details.getWakaPointId());

        return res;
    }

    public BookFlightResponseD mapBooking(BookingFlightResponse res){
        BookFlightResponseD book = new BookFlightResponseD();

        book.setBookingId(res.getBookingId());
        book.setProductType(res.getProductType());
        book.setTargetCurrency(res.getTargetCurrency());
        book.setFlightBookingResult(mapFlightBookingResult(res.getFlightBookingResult()));
        book.setProductTermsAndConditions(mapTerms(res.getProductTermsAndConditions()));
        book.setCustomerId(res.getCustomerId());
        book.setSelectedPaySmallSmallPlan(res.getSelectedPaySmallSmallPlan());

        return book;
    }

    private FlightBookingSummaryD mapBookingSummary(FlightBookingSummary sum){
        FlightBookingSummaryD summaryD = new FlightBookingSummaryD();

        summaryD.setFlightSummaryModel(summaryMapper(sum.getFlightSummaryModel()));
        summaryD.setPnrDate(sum.getPnrDate());
        summaryD.setTicketStatus(sum.getTicketStatus());
        summaryD.setPnrReferenceNumber(sum.getPnrReferenceNumber());
        summaryD.setTravellerDetails(sum.getTravellerDetails().stream().map(this::mapTravellerDetails)
                .collect(Collectors.toList()));

        return summaryD;
    }

    private DiscountD mapDiscount(Discount dis){
        DiscountD discount = new DiscountD();

        discount.setAmount(dis.getAmount());
        discount.setCurrencyCode(dis.getCurrencyCode());

        return discount;
    }

    private TotalAddonAmountD mapTotalAddon(TotalAddonAmount amt){
        TotalAddonAmountD addOns = new TotalAddonAmountD();

        addOns.setAmount(amt.getAmount());
        addOns.setCurrencyCode(amt.getCurrencyCode());

        return addOns;
    }
    private FranchiseMarkupD mapFranchiseMarkup(FranchiseMarkup markup){
        FranchiseMarkupD franchise = new FranchiseMarkupD();

        franchise.setAmount(markup.getAmount());
        franchise.setCurrencyCode(markup.getCurrencyCode());

        return franchise;
    }

    private TotalTripPriceD mapTotalTripPrice(TotalTripPrice trip){
        TotalTripPriceD price = new TotalTripPriceD();

        price.setAmount(trip.getAmount());
        price.setCurrencyCode(trip.getCurrencyCode());

        return price;
    }

    private BookingPaymentDetailsD mapBookingPayment(BookingPaymentDetails details){
        BookingPaymentDetailsD payment = new BookingPaymentDetailsD();

        payment.setPaymentLink(details.getPaymentLink());
        payment.setPaymentMethodId(details.getPaymentMethodId());
        payment.setPaymentOptionId(details.getPaymentOptionId());
        payment.setPaymentStatus(details.getPaymentStatus());
        payment.setPaymentMethodName(details.getPaymentMethodName());
        payment.setDiscount(mapDiscount(details.getDiscount()));
        payment.setFranchiseMarkup(mapFranchiseMarkup(details.getFranchiseMarkup()));
        payment.setPayBankDetails(details.getPayBankDetails());
        payment.setPaymentReferenceCode(details.getPaymentReferenceCode());
        payment.setPaymentOptionName(details.getPaymentOptionName());
        payment.setSendForApproval(details.getSendForApproval());
        payment.setTotalAddonAmount(mapTotalAddon(details.getTotalAddonAmount()));
        payment.setTotalTripPrice(mapTotalTripPrice(details.getTotalTripPrice()));

        return payment;
    }

    private BookingStatusDetailsD mapBookingStatus(BookingStatusDetails status){
        BookingStatusDetailsD details = new BookingStatusDetailsD();

        details.setBookingStatus(status.getBookingStatus());
        details.setPnrStatus(status.getPnrStatus());
        details.setPaymentStatus(status.getPaymentStatus());
        details.setMessage(status.getMessage());
        details.setTicketingStatus(status.getTicketingStatus());
        details.setAvailabilityMessage(status.getAvailabilityMessage());
        details.setCovidAlertMessage(status.getCovidAlertMessage());
        details.setGeographyCode(status.getGeographyCode());
        details.setPaymentRemarks(status.getPaymentRemarks());

        return details;
    }

    public FlightTicketResponseD mapTickets(FlightTicketResponse ticket){
        FlightTicketResponseD flight = new FlightTicketResponseD();

        flight.setCustomerId(ticket.getCustomerId());
        flight.setFlightBookingSummary(mapBookingSummary(ticket.getFlightBookingSummary()));
        flight.setProductTermsAndConditions(mapTermsAndConditions(ticket.getProductTermsAndConditions()));
        flight.setBookingId(ticket.getBookingId());
        flight.setSelectedPaySmallSmallPlan(ticket.getSelectedPaySmallSmallPlan());
        flight.setBookingPaymentDetails(mapBookingPayment(ticket.getBookingPaymentDetails()));
        flight.setBookingStatusDetails(mapBookingStatus(ticket.getBookingStatusDetails()));
        flight.setProductType(ticket.getProductType());

        return flight;

    }
}
