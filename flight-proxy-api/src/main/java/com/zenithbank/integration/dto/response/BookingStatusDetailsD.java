package com.zenithbank.integration.dto.response;

import lombok.Data;

@Data
public class BookingStatusDetailsD {
    String pnrStatus;
    String ticketingStatus;
    String paymentStatus;
    String bookingStatus;
    String message;
    String geographyCode;
    String paymentRemarks;
    String availabilityMessage;
    String covidAlertMessage;
}
