package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class FlightSerchResponse {
    @JsonProperty("FlightCombination")
    private FlightCombination flightCombination;
    @JsonProperty("SelectData")
    private String selectData;

}
