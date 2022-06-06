package com.zenithbank.integration.dto;

import lombok.Data;

import java.util.List;

@Data
public class SearchRequestDto {
    String flightSearchType;
    String adults;
    String children;
    String infants;
    String ticketclass;
    String targetCurrency;
    List<ItineraryDto> itineraries;
}
