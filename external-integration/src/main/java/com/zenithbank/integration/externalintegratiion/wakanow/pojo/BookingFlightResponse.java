package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class BookingFlightResponse {
    @JsonProperty("BookingId")
    String bookingId;
    @JsonProperty("CustomerId")
    String customerId;
    @JsonProperty("ProductType")
    String productType;
    @JsonProperty("TargetCurrency")
    String targetCurrency;
    @JsonProperty("ProductTermsAndConditions")
    TermsAndConditions productTermsAndConditions;
    @JsonProperty("FlightBookingResult")
    FlightBookingResult flightBookingResult;
    @JsonProperty("SelectedPaySmallSmallPlan")
    String selectedPaySmallSmallPlan;
}
