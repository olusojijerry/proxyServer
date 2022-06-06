package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class SelectFlightResponseD {
    private FlightSummaryModelD flightSummaryModel;
    private Boolean isPriceMatched;
    private Boolean hasResult;
    private String selectData;
    private ProductTermsAndConditionsD productTermsAndConditions;
    private String bookingId;
    private Boolean isPassportRequired;
    private List<CustomMessagesD> customMessages;
    Long partnerId;
}
