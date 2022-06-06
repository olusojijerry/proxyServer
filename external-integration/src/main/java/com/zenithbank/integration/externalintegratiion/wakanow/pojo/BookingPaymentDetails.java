package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class BookingPaymentDetails{
    @JsonProperty("PaymentStatus")
    String paymentStatus;
    //    @JsonProperty("TotalPrice")
//    List<TotalPrice> totalPrice;
    @JsonProperty("FranchiseMarkup")
    FranchiseMarkup franchiseMarkup;
    @JsonProperty("PaymentOptionId")
    Long paymentOptionId;
    @JsonProperty("PaymentMethodId")
    Long paymentMethodId;
    @JsonProperty("PaymentOptionName")
    String paymentOptionName;
    @JsonProperty("PaymentMethodName")
    String paymentMethodName;
    @JsonProperty("PaymentLink")
    String paymentLink;
    @JsonProperty("PayBankDetails")
    String payBankDetails;
    @JsonProperty("PaymentReferenceCode")
    String paymentReferenceCode;
    @JsonProperty("TotalAddonAmount")
    TotalAddonAmount totalAddonAmount;
    @JsonProperty("TotalTripPrice")
    TotalTripPrice totalTripPrice;
    @JsonProperty("Discount")
    Discount discount;
    @JsonProperty("SendForApproval")
    Boolean sendForApproval;
}
