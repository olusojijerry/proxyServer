package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;

@Data
@Generated("com.robohorse.robopojogenerator")
public class TravellerDetails{
    @JsonProperty("PassengerType")
    String passengerType;
    @JsonProperty("FirstName")
    String firstName;
    @JsonProperty("MiddleName")
    String middleName;
    @JsonProperty("LastName")
    String lastName;
    @JsonProperty("DateOfBirth")
    Date dateOfBirth;
    @JsonProperty("Age")
    Long age;
    @JsonProperty("PhoneNumber")
    String phoneNumber;
    @JsonProperty("ExpiryDate")
    Date expiryDate;
    @JsonProperty("PassportIssuingAuthority")
    String passportIssuingAuthority;
    @JsonProperty("PassportIssueCountryCode")
    String passportIssueCountryCode;
    @JsonProperty("Gender")
    String gender;
    @JsonProperty("Title")
    String title;
    @JsonProperty("Email")
    String email;
    @JsonProperty("Address")
    String address;
    @JsonProperty("Country")
    String country;
    @JsonProperty("CountryCode")
    String countryCode;
    @JsonProperty("City")
    String city;
    @JsonProperty("PostalCode")
    String postalCode;
    @JsonProperty("TicketNumber")
    String ticketNumber;
    @JsonProperty("RoomNumber")
    String roomNumber;
    @JsonProperty("SelectedSeats")
    String selectedSeats;
    @JsonProperty("PassengerReferenceNumber")
    String passengerReferenceNumber;
    @JsonProperty("SelectedBaggages")
    String selectedBaggages;
    @JsonProperty("WakaPointId")
    String wakaPointId;
    @JsonProperty("IsWakapointRegister")
    Boolean isWakapointRegister;
}
