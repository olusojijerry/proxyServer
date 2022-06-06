package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class FlightBookingResult{
    @JsonProperty("FlightBookingSummaryModel")
    FlightBookingSummaryModel flightBookingSummaryModel;
    @JsonProperty("IsFareLow")
    Boolean isFareLow;
    @JsonProperty("IsFareHigh")
    Boolean isFareHigh;
    @JsonProperty("HasResult")
    Boolean hasResult;

}
