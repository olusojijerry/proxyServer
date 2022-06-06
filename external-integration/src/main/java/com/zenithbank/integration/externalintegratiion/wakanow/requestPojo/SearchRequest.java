package com.zenithbank.integration.externalintegratiion.wakanow.requestPojo;

import lombok.Data;

import java.util.List;

@Data
public class SearchRequest {
    String flightSearchType;
    String adults;
    String children;
    String infants;
    String ticketclass;
    String targetCurrency;
    List<Itinerary> itineraries;
}
