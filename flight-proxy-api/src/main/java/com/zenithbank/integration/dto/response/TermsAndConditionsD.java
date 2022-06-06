package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class TermsAndConditionsD {
    List<String> TermsAndConditions;
    String TermsAndConditionImportantNotice;
}
