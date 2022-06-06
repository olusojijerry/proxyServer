package com.zenithbank.integration.externalintegratiion.feign.client;

import com.zenithbank.integration.externalintegratiion.WakanowFeignClientConfiguration;
import com.zenithbank.integration.externalintegratiion.wakanow.pojo.BookingFlightResponse;
import com.zenithbank.integration.externalintegratiion.wakanow.pojo.FlightSerchResponse;
import com.zenithbank.integration.externalintegratiion.wakanow.pojo.FlightTicketResponse;
import com.zenithbank.integration.externalintegratiion.wakanow.pojo.SelectFlightResponse;
import com.zenithbank.integration.externalintegratiion.wakanow.requestPojo.BookFlightRequest;
import com.zenithbank.integration.externalintegratiion.wakanow.requestPojo.FlightTicketRequest;
import com.zenithbank.integration.externalintegratiion.wakanow.requestPojo.SearchRequestWakanow;
import com.zenithbank.integration.externalintegratiion.wakanow.requestPojo.SelectRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "flight-proxy-api", url = "${core.integration.wakanow.base-url:https://wakanow-api-affiliate-b2b-devtest-test.azurewebsites.net}",
configuration = WakanowFeignClientConfiguration.class)
public interface WakanowClient {
    @PostMapping("${core.integration.wakanow.api.flightSearch:api/flight/search}")
    List<FlightSerchResponse> searchForFlight(@RequestBody SearchRequestWakanow request);
    @PostMapping("${core.integration.wakanow.api.flightSelect:api/flight/select}")
    SelectFlightResponse selectFlight(@RequestBody SelectRequest req);
    @GetMapping("${core.integration.wakanow.api.airports:api/flight/airports}")
    HttpEntity<byte[]> getAirports();
    @PostMapping("${core.integration.wakanow.api.flightBooking:api/flight/book}")
    BookingFlightResponse bookFlight(BookFlightRequest bookFlightRequest);
    @PostMapping("${core.integration.wakanow.api.flightTicket:api/flight/ticketpnr}")
    FlightTicketResponse flightTicket(FlightTicketRequest flightTicketRequest);
}
