package com.zenithbank.integration.dto.response;

import lombok.Data;

@Data
public class BookFlightResponseD {
    String bookingId;
    String customerId;
    String productType;
    String targetCurrency;
    TermsAndConditionsD productTermsAndConditions;
    FlightBookingResultD flightBookingResult;
    String selectedPaySmallSmallPlan;
    Long partnerId;
}
