package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FlightLegD {
    private String flightLegNumber;
    private String departureCode;
    private String departureName;
    private String destinationCode;
    private String destinationName;
    private Date startTime;
    private Date endTime;
    private String duration;
    private Boolean isStop;
    private String layOver;
    private String layOverDuration;
    private String bookingClass;
    private String cabinClass;
    private String cabinClassName;
    private String operatingCarrier;
    private String operatingCarrierName;
    private String marketingCarrier;
    private String fightNumber;
    private String aircraft;
    private String seats;
    private List<String> technicalStops;
    private String flightSelectData;
    private String corporateCode;
    private String status;
    private String fareBasisCode;
    private String fareType;
}
