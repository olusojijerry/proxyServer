package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class BookingStatusDetails{
    @JsonProperty("PnrStatus")
    String pnrStatus;
    @JsonProperty("TicketingStatus")
    String ticketingStatus;
    @JsonProperty("PaymentStatus")
    String paymentStatus;
    @JsonProperty("BookingStatus")
    String bookingStatus;
    @JsonProperty("Message")
    String message;
    @JsonProperty("GeographyCode")
    String geographyCode;
    @JsonProperty("PaymentRemarks")
    String paymentRemarks;
    @JsonProperty("AvailabilityMessage")
    String availabilityMessage;
    @JsonProperty("CovidAlertMessage")
    String covidAlertMessage;
}
