package com.zenithbank.integration.dto.response;


import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FlightCombinationD {
    private String connectionCode;
    private BigDecimal paySmallSmallLockDownPrice;
    private Long downloadPaymentDetailInPercentage;
    private Boolean includePaySmallSmall;
    private String nonRefundableFreeText;
    private Boolean isRefundable;
    private String airlineCode;
    private List<String> penaltyRules;
    private List<String> fareRules;
    private String marketingCarrier;
    private Long adults;
    private Long children;
    private Long infants;
    private List<FlightModelsD> flightModels;
    private PriceD price;
}
