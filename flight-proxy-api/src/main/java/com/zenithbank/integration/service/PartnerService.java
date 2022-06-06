package com.zenithbank.integration.service;

import com.querydsl.core.BooleanBuilder;
import com.zenithbank.integration.config.exception.ApiException;
import com.zenithbank.integration.entity.flight.CorePartners;
import com.zenithbank.integration.dto.PartnersDto;
import com.zenithbank.integration.entity.flight.CoreUser;
import com.zenithbank.integration.entity.flight.QCoreBookingDetails;
import com.zenithbank.integration.utils.Util;
import com.zenithbank.integration.entity.flight.CoreBookingDetails;
import com.zenithbank.integration.services.CoreBookingDetailsService;
import com.zenithbank.integration.services.CorePartnerService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.text.ParseException;
import java.util.Date;

@Service
public class PartnerService {
    @Autowired
    CorePartnerService corePartnerService;
    @Autowired
    CoreBookingDetailsService coreBookingDetailsService;

    public CorePartners createPartner(PartnersDto partnersDto, CoreUser user){
        CorePartners partners = partnerMapper(partnersDto, user);

        partners = corePartnerService.saveOrUpdate(partners);

        return partners;
    }

    private CorePartners partnerMapper(PartnersDto partner, CoreUser usser){
        CorePartners corePartners = new CorePartners();

        corePartners.setPartnerName(partner.getPartnerName());
        corePartners.setCreatedBy(usser.getUserName());
        corePartners.setCreatedDt(new Date());
        corePartners.setDescription(partner.getDescription());
        corePartners.setCreditAcctNo(partner.getCreditAcctNo());
        corePartners.setStatus(partner.getStatus());
        corePartners.setCreditAcctNo(partner.getCreditAcctNo());

        return corePartners;
    }

    public CorePartners findpartnerById(@NonNull Long partnerId){
        return corePartnerService.findById(partnerId).orElseThrow(() ->
                new ApiException(String.format("Cannot find Partner with Id: %d", partnerId)));
    }

    public Page<CorePartners> findAll(Pageable pageable){
        return corePartnerService.findAll(pageable);
    }

    public Page<CoreBookingDetails> getAllBookingDetails(String bookingId, String status, String passportNo,
                                                         String phoneNo, Long partnerId, Date fromDate, Date toDate,
                                                         Pageable pageable) throws ParseException {
        QCoreBookingDetails qCoreBookingDetails = QCoreBookingDetails.coreBookingDetails;

        BooleanBuilder builder = new BooleanBuilder();

        if(!ObjectUtils.isEmpty(bookingId))
            qCoreBookingDetails.bookingId.eq(bookingId);

        if(!ObjectUtils.isEmpty(status))
            qCoreBookingDetails.status.eq(status);

        if(!ObjectUtils.isEmpty(passportNo))
            qCoreBookingDetails.passportNumber.eq(passportNo);

        if(!ObjectUtils.isEmpty(phoneNo))
            qCoreBookingDetails.phoneNumber.eq(phoneNo);

        if(!ObjectUtils.isEmpty(partnerId))
            qCoreBookingDetails.partnerId.eq(partnerId);

        if (!ObjectUtils.isEmpty(fromDate)){
            Assert.notNull(toDate, "Enter the search end date.");

            toDate = Util.addDaysToDate(toDate, 1);

            qCoreBookingDetails.createdDt.between(fromDate, toDate);
        }

        return coreBookingDetailsService.findAllBookingDetails(builder, pageable);
    }

    public CoreBookingDetails getDetailsById(@NonNull Long id){
       return coreBookingDetailsService.findById(id).orElseThrow(() ->
               new ApiException(String.format("Cannot Find Booking Details with Id: %d", id)));
    }
}
