package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FlightSummaryModelD {
    private FlightCombinationD flightCombination;
    private BigDecimal PriceBreakUps;
}
