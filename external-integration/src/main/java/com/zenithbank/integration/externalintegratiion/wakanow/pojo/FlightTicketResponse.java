package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Generated("com.robohorse.robopojogenerator")
public class FlightTicketResponse {
    @JsonProperty("BookingId")
    String bookingId;
    @JsonProperty("CustomerId")
    String customerId;
    @JsonProperty("ProductType")
    String productType;
    @JsonProperty("FlightBookingSummary")
    FlightBookingSummary flightBookingSummary;
    @JsonProperty("ProductTermsAndConditions")
    ProductTermsAndConditions productTermsAndConditions;
    @JsonProperty("BookingStatusDetails")
    BookingStatusDetails BookingStatusDetails;
    @JsonProperty("SelectedPaySmallSmallPlan")
    String selectedPaySmallSmallPlan;
    @JsonProperty("BookingPaymentDetails")
    BookingPaymentDetails BookingPaymentDetails;
//    @JsonProperty("BillingAddress")
//    List<String> billingAddress;
}

@Data
@Generated("com.robohorse.robopojogenerator")
class TotalPrice extends  Price{

}






