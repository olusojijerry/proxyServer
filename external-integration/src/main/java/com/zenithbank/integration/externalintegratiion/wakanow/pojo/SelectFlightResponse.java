package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
public class SelectFlightResponse {
    @JsonProperty("FlightSummaryModel")
    private FlightSummaryModel flightSummaryModel;
    @JsonProperty("IsPriceMatched")
    private Boolean isPriceMatched;
    @JsonProperty("HasResult")
    private Boolean hasResult;
    @JsonProperty("SelectData")
    private String selectData;
    @JsonProperty("ProductTermsAndConditions")
    private ProductTermsAndConditions productTermsAndConditions;
    @JsonProperty("BookingId")
    private String bookingId;
    @JsonProperty("IsPassportRequired")
    private Boolean isPassportRequired;
    @JsonProperty("CustomMessages")
    private List<CustomMessages> customMessages;
}
