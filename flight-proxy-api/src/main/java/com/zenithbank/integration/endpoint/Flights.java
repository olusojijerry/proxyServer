package com.zenithbank.integration.endpoint;

import com.zenithbank.integration.auth.annotation.Auth;
import com.zenithbank.integration.config.pojo.RestResponsePojo;
import com.zenithbank.integration.dto.BookFlightDto;
import com.zenithbank.integration.dto.SelectRequestDto;
import com.zenithbank.integration.dto.response.BookFlightResponseD;
import com.zenithbank.integration.dto.response.FlightSearchResponse;
import com.zenithbank.integration.dto.response.FlightTicketResponseD;
import com.zenithbank.integration.dto.response.SelectFlightResponseD;
import com.zenithbank.integration.entity.flight.CoreUser;
import com.zenithbank.integration.service.IntegrationService;
import com.zenithbank.integration.service.WakanowRegistratioService;
import com.zenithbank.integration.dto.FlightTicketDto;
import com.zenithbank.integration.dto.SearchRequestDto;
import com.zenithbank.integration.services.CoreBookingDetailsService;
import com.zenithbank.integration.services.CorePartnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api/flight/wakanow")
@Slf4j
public class Flights {

    @Autowired
    WakanowRegistratioService wakanowService;
    @Autowired
    EntityManager entityManager;
    @Autowired
    CorePartnerService corePartnerService;
    @Autowired
    CoreBookingDetailsService coreBookingDetailsService;
    IntegrationService integrationService;


    @PostMapping("search")
    public RestResponsePojo<?> searchFlight(@Auth CoreUser user,
                                            @RequestBody SearchRequestDto request){
        RestResponsePojo<List<FlightSearchResponse>> responsePojo = new RestResponsePojo<>();

        integrationService = new IntegrationService(wakanowService, entityManager,
                corePartnerService, coreBookingDetailsService);

        List<FlightSearchResponse> responses = integrationService.searchForFlight(request);

        responsePojo.setMessage("Successful");
        responsePojo.setData(responses);

        return responsePojo;
    }

    @PostMapping("select")
    public RestResponsePojo<?> selectFlight(@RequestBody SelectRequestDto selectRequestDto){
        RestResponsePojo<SelectFlightResponseD> responsePojo = new RestResponsePojo<>();

        integrationService = new IntegrationService(wakanowService, entityManager,
                corePartnerService, coreBookingDetailsService);

        SelectFlightResponseD response = integrationService.selectFlight(selectRequestDto);

        responsePojo.setData(response);
        responsePojo.setMessage("Successful");

        return responsePojo;
    }

    @GetMapping("airports")
    public HttpEntity<byte[]> getAllAirport(){
        return wakanowService.downloadAirports();
    }

    @PostMapping("/book")
    @Transactional
    public RestResponsePojo<?> bookAFlight(@Auth CoreUser user,
                                            @RequestBody BookFlightDto bookFlightDto){
        RestResponsePojo<BookFlightResponseD> responsePojo = new RestResponsePojo<>();

        integrationService = new IntegrationService(wakanowService, entityManager,
                corePartnerService, coreBookingDetailsService);

        BookFlightResponseD response = integrationService.bookFlight(bookFlightDto, user);

        responsePojo.setData(response);
        responsePojo.setMessage("Successful");

        return responsePojo;
    }

    @PostMapping("/ticket")
    public RestResponsePojo<?> getBooketFlightTicket(@RequestBody FlightTicketDto flightTicketDto){
        RestResponsePojo<FlightTicketResponseD> responsePojo = new RestResponsePojo<>();

        integrationService = new IntegrationService(wakanowService, entityManager,
                corePartnerService, coreBookingDetailsService);

        FlightTicketResponseD response = integrationService.getFlightTicket(flightTicketDto);

        responsePojo.setMessage("Successful");
        responsePojo.setData(response);

        return responsePojo;
    }
}
