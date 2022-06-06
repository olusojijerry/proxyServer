package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
public class FlightCombination {
    @JsonProperty("FlightModels")
    private List<FlightModels> flightModels;
    @JsonProperty("Price")
    private Price price;
//    @JsonProperty("PriceDetails")
//    private PriceDetails priceDetails;
    @JsonProperty("MarketingCarrier")
    private String marketingCarrier;
    @JsonProperty("Adults")
    private Long adults;
    @JsonProperty("Children")
    private Long children;
    @JsonProperty("Infants")
    private Long infants;
    @JsonProperty("FareRules")
    private List<String> fareRules;
    @JsonProperty("PenaltyRules")
    private List<String> penaltyRules;
    @JsonProperty("AirlineCode")
    private String airlineCode;
    @JsonProperty("IsRefundable")
    private Boolean isRefundable;
    @JsonProperty("NonRefundableFreeText")
    private String nonRefundableFreeText;
    @JsonProperty("IncludePaySmallSmall")
    private Boolean includePaySmallSmall;
    @JsonProperty("DownPaymentDetailInPercentage")
    private Long downloadPaymentDetailInPercentage;
    @JsonProperty("PaySmallSmallLockDownPrice")
    private BigDecimal paySmallSmallLockDownPrice;
    @JsonProperty("ConnectionCode")
    private String connectionCode;

}




