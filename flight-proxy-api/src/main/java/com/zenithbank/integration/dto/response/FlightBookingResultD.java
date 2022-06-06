package com.zenithbank.integration.dto.response;

import lombok.Data;

@Data
public class FlightBookingResultD {
    FlightBookingSummaryModelD flightBookingSummaryModel;
    Boolean isFareLow;
    Boolean isFareHigh;
    Boolean hasResult;
}
