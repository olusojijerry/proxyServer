package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceD {
    private BigDecimal amount;
    private String currencyCode;
}
