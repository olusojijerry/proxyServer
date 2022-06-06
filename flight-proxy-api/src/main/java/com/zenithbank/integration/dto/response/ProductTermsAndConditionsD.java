package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductTermsAndConditionsD {
    private List<String> termsAndConditions;
    private String termsAndConditionImportantNotice;
}
