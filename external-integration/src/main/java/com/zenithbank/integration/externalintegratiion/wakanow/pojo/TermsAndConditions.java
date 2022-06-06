package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
public class TermsAndConditions{
    @JsonProperty("TermsAndConditions")
    List<String> TermsAndConditions;
    @JsonProperty("TermsAndConditionImportantNotice")
    String TermsAndConditionImportantNotice;
}
