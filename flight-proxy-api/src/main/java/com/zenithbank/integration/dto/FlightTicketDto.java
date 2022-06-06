package com.zenithbank.integration.dto;

import lombok.Data;

@Data
public class FlightTicketDto {
    String bookingId;
    String pnrNumber;
    Long partnerId;
}
