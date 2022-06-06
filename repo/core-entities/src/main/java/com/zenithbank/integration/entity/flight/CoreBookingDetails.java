package com.zenithbank.integration.entity.flight;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "BookingDetails")
public class CoreBookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;
    @Column(name = "PARTNER_ID")
    Long partnerId;
    @Column(name = "POSTING_REFERENCE")
    String postingReference;
    @Column(name = "PARTNER_NAME")
    String partnerName;
    @Column(name = "BOOKING_REFERENCE")
    String bookingReference;
    @Column(name = "ACCOUNT_NO")
    String accountNo;
    @Column(name = "STATUS")
    String status;
    @Column(name = "CREATED_DT")
    Date createdDt;
    @Column(name = "CREATED_BY")
    String createdBy;
    @Column(name = "PASSENGER_TYPE")
    String passengerType;
    @Column(name = "FIRST_NAME")
    String firstName;
    @Column(name = "MIDDLE_NAME")
    String middleName;
    @Column(name = "LAST_NAME")
    String lastName;
    @Column(name = "DATE_OF_BIRTH")
    String dateOfBirth;
    @Column(name = "PHONE_NUMBER")
    String phoneNumber;
    @Column(name = "ADDRESS")
    String address;
    @Column(name = "PASSPORT_NO")
    String passportNumber;
    @Column(name = "EXPIRY_DT")
    String expiryDate;
    @Column(name = "PASSPORT_ISSUING_AUTH")
    String passportIssuingAuthority;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "GENDER")
    String gender;
    @Column(name = "TITLE")
    String title;
    @Column(name = "CITY")
    String city;
    @Column(name = "COUNTRY")
    String country;
    @Column(name = "COUNTRY_CODE")
    String countryCode;
    @Column(name = "POSTAL_CODE")
    String postalCode;
    @Column(name = "BOOKING_ID")
    String bookingId;
    @Column(name = "BOOKING_DATA", length = 4000)
    String bookingData;
    @Column(name = "PRODUCT_TYPE")
    String productType;
    @Column(name = "TARGET_CURRENCY")
    String targetCurrency;
}
