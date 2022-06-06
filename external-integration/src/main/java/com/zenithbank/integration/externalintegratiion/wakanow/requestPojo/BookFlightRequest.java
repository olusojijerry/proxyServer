package com.zenithbank.integration.externalintegratiion.wakanow.requestPojo;

import lombok.Data;

import java.util.List;

@Data
public class BookFlightRequest {
    List<PassengerDetails> PassengerDetails;
    List<BookingItemModels> BookingItemModels;
    String BookingId;
}