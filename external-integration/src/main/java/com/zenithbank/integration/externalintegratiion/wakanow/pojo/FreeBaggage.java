package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class FreeBaggage{
    @JsonProperty("BagCount")
    private Long bagCount;
    @JsonProperty("BagWeight")
    private Double bagWeight;
    @JsonProperty("WeightUnit")
    private String weightUnit;
}
