package com.zenithbank.integration.dto.response;

import lombok.Data;

@Data
public class FlightTicketResponseD {
    String bookingId;
    String customerId;
    String productType;
    FlightBookingSummaryD flightBookingSummary;
    ProductTermsAndConditionsD productTermsAndConditions;
    BookingStatusDetailsD BookingStatusDetails;
    String selectedPaySmallSmallPlan;
    BookingPaymentDetailsD BookingPaymentDetails;
    Long partnerId;
}
