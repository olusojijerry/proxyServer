package com.zenithbank.integration.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class PartnersDto {
    String partnerName;
    String description;
    String creditAcctNo;
    String creditAcctType;
    String status;
    String createdBy;
    Date createdDt;
}
