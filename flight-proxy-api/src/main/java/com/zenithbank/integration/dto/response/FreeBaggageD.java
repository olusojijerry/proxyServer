package com.zenithbank.integration.dto.response;

import lombok.Data;

@Data
public class FreeBaggageD {
    private Long bagCount;
    private Double bagWeight;
    private String weightUnit;
}
