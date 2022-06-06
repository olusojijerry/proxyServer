package com.zenithbank.integration.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class SelectRequestDto {
    String targetCurrency;
    String selectData;
    Long partnerId;
}
