package com.zenithbank.integration.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookFlightDto {
    List<PassengerDetailsDto> PassengerDetails;
    List<BookingItemModelsDto> BookingItemModels;
    String BookingId;
    Long partnerId;
    String accountNo;
    String postingRef;
}

