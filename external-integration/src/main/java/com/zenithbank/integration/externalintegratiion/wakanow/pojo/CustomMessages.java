package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class CustomMessages{
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("SeverityLevel")
    private String securityLevel;
}
