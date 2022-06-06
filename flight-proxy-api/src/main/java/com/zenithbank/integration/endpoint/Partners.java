package com.zenithbank.integration.endpoint;


import com.zenithbank.integration.auth.annotation.Auth;
import com.zenithbank.integration.config.pojo.RestResponsePojo;
import com.zenithbank.integration.entity.flight.CorePartners;
import com.zenithbank.integration.entity.flight.CoreUser;
import com.zenithbank.integration.utils.Constant;
import com.zenithbank.integration.entity.flight.CoreBookingDetails;
import com.zenithbank.integration.dto.PartnersDto;
import com.zenithbank.integration.service.PartnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("api/partner")
@Slf4j
public class Partners {
    @Autowired
    PartnerService corePartnerService;

    @PostMapping("")
    public RestResponsePojo<CorePartners> createPartner(@Auth CoreUser user,
                                                        @RequestBody PartnersDto partnersDto){
        RestResponsePojo<CorePartners> restResponsePojo = new RestResponsePojo<>();

        CorePartners partners = corePartnerService.createPartner(partnersDto,user);

        restResponsePojo.setData(partners);
        restResponsePojo.setMessage("Successful");

        return restResponsePojo;
    }

    @GetMapping("/{partnerId}")
    public RestResponsePojo<CorePartners> getPartnerById(@PathVariable(name = "partnerId") Long partnerId){
        RestResponsePojo<CorePartners> restResponsePojo = new RestResponsePojo<>();

        CorePartners partners = corePartnerService.findpartnerById(partnerId);

        restResponsePojo.setMessage("Successful");
        restResponsePojo.setData(partners);

        return restResponsePojo;
    }

    @GetMapping("")
    public RestResponsePojo<Page<CorePartners>> getAllPartners(Pageable pageable){
        RestResponsePojo<Page<CorePartners>> responsePojo = new RestResponsePojo<>();

        Page<CorePartners> partners = corePartnerService.findAll(pageable);

        responsePojo.setData(partners);
        responsePojo.setMessage("Successful");

        return responsePojo;
    }

    @GetMapping("/bookings")
    public RestResponsePojo<Page<CoreBookingDetails>> getAllBookingDetails(@RequestParam(name = "bookingId", required = false) String bookingId,
                                                                           @RequestParam(name = "status", required = false) String status,
                                                                           @RequestParam(name = "passportNo", required = false) String passportNo,
                                                                           @RequestParam(name = "phoneNo", required = false)String phoneNo,
                                                                           @RequestParam(name = "partnerId", required = false) Long partnerId,
                                                                           @RequestParam(name = "fromDate", required = false)
                                                                                @DateTimeFormat(pattern = Constant.SERVER_DATETIME_FORMAT)Date fromDate,
                                                                           @RequestParam(name = "toDate", required = false)
                                                                                @DateTimeFormat(pattern = Constant.SERVER_DATETIME_FORMAT) Date toDate,
                                                                           Pageable pageable) throws ParseException {
        RestResponsePojo<Page<CoreBookingDetails>> responsePojo = new RestResponsePojo<>();

        Page<CoreBookingDetails> res = corePartnerService.getAllBookingDetails(bookingId, status,
                passportNo, phoneNo, partnerId, fromDate, toDate, pageable);

        responsePojo.setMessage("Successful");
        responsePojo.setData(res);

        return responsePojo;
    }

    @GetMapping("booking/{bookingId}")
    public RestResponsePojo<CoreBookingDetails> getBookingDetailsById(@PathVariable(name = "bookingId") Long id){
        RestResponsePojo<CoreBookingDetails> restResponsePojo = new RestResponsePojo<>();

        CoreBookingDetails details = corePartnerService.getDetailsById(id);

        restResponsePojo.setData(details);
        restResponsePojo.setMessage("Successful");

        return restResponsePojo;
    }
}
