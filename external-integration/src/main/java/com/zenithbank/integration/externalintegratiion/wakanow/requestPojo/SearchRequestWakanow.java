package com.zenithbank.integration.externalintegratiion.wakanow.requestPojo;

import lombok.Data;

import java.util.List;

@Data
public class SearchRequestWakanow {
    String FlightSearchType;
    String Adults;
    String Children;
    String Infants;
    String Ticketclass;
    String TargetCurrency;
    List<ItineraryWakanow> Itineraries;
}
