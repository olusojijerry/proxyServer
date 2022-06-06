package com.zenithbank.integration.externalintegratiion.wakanow.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("core.integration.wakanow.api")
public class Api {
    private String login = "token";
    private String airports = "api/flight/airports";
    private String flightSearch = "api/flight/search";
    private String flightSelect = "api/flight/select";
    private String flightBooking = "api/flight/book";
    private String flightTicket = "api/flight/ticketpnr";
}
