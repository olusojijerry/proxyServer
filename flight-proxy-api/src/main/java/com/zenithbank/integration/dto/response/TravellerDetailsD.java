package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class TravellerDetailsD {
    String passengerType;
    String firstName;
    String middleName;
    String lastName;
    Date dateOfBirth;
    Long age;
    String phoneNumber;
    Date expiryDate;
    String passportIssuingAuthority;
    String passportIssueCountryCode;
    String gender;
    String title;
    String email;
    String address;
    String country;
    String countryCode;
    String city;
    String postalCode;
    String ticketNumber;
    String roomNumber;
    String selectedSeats;
    String passengerReferenceNumber;
    String selectedBaggages;
    String wakaPointId;
    Boolean isWakapointRegister;
}
