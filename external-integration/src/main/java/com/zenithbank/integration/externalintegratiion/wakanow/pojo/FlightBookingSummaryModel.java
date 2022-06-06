package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
public class FlightBookingSummaryModel{
    @JsonProperty("PnrReferenceNumber")
    String pnrReferenceNumber;
    @JsonProperty("PnrDate")
    Date pnrDate;
    @JsonProperty("FlightSummaryModel")
    FlightSummaryModel flightSummaryModel;
    @JsonProperty("TravellerDetails")
    List<TravellerDetails> travellerDetails;
    @JsonProperty("PnrStatus")
    String pnrStatus;
    @JsonProperty("TicketStatus")
    String ticketStatus;
}
