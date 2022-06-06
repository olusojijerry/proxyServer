package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.math.BigDecimal;

@Data
@Generated("com.robohorse.robopojogenerator")
public class FlightSummaryModel{
    @JsonProperty("FlightCombination")
    private FlightCombination flightCombination;
    @JsonProperty("PriceBreakups")
    private BigDecimal PriceBreakUps;
}
