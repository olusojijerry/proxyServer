package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FlightBookingSummaryD {
    String pnrReferenceNumber;
    Date pnrDate;
    FlightSummaryModelD flightSummaryModel;
    List<TravellerDetailsD> travellerDetails;
    String pnrStatus;
    String ticketStatus;
}
