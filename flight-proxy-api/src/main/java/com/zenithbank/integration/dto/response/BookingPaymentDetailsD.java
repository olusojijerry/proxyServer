package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class BookingPaymentDetailsD {
    String paymentStatus;
    List<TotalPrice> totalPrice;
    FranchiseMarkupD franchiseMarkup;
    Long paymentOptionId;
    Long paymentMethodId;
    String paymentOptionName;
    String paymentMethodName;
    String paymentLink;
    String payBankDetails;
    String paymentReferenceCode;
    TotalAddonAmountD totalAddonAmount;
    TotalTripPriceD totalTripPrice;
    DiscountD discount;
    Boolean sendForApproval;
}
