package com.zenithbank.integration.dto.response;

import lombok.Data;

@Data
public class FlightSearchResponse {
    private FlightCombinationD flightCombination;
    private String selectData;
    private Long partnerId;
}
