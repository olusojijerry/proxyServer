package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
public class ProductTermsAndConditions{
    @JsonProperty("TermsAndConditions")
    private List<String> termsAndConditions;
    @JsonProperty("TermsAndConditionImportantNotice")
    private String termsAndConditionImportantNotice;
}
