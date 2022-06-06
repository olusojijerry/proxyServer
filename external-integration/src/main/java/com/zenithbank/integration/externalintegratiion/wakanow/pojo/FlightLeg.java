package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
public class FlightLeg{
    @JsonProperty("FlightLegNumber")
    private String flightLegNumber;
    @JsonProperty("DepartureCode")
    private String departureCode;
    @JsonProperty("DepartureName")
    private String departureName;
    @JsonProperty("DestinationCode")
    private String destinationCode;
    @JsonProperty("DestinationName")
    private String destinationName;
    @JsonProperty("StartTime")
    private Date startTime;
    @JsonProperty("EndTime")
    private Date endTime;
    @JsonProperty("Duration")
    private String duration;
    @JsonProperty("IsStop")
    private Boolean isStop;
    @JsonProperty("Layover")
    private String layOver;
    @JsonProperty("LayoverDuration")
    private String layOverDuration;
    @JsonProperty("BookingClass")
    private String bookingClass;
    @JsonProperty("CabinClass")
    private String cabinClass;
    @JsonProperty("CabinClassName")
    private String cabinClassName;
    @JsonProperty("OperatingCarrier")
    private String operatingCarrier;
    @JsonProperty("OperatingCarrierName")
    private String operatingCarrierName;
    @JsonProperty("MarketingCarrier")
    private String marketingCarrier;
    @JsonProperty("FlightNumber")
    private String fightNumber;
    @JsonProperty("Aircraft")
    private String aircraft;
    @JsonProperty("Seats")
    private String seats;
    @JsonProperty("TechnicalStops")
    private List<String> technicalStops;
    @JsonProperty("FlightSelectData")
    private String flightSelectData;
    @JsonProperty("CorporateCode")
    private String corporateCode;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("FarebasisCode")
    private String fareBasisCode;
    @JsonProperty("FareType")
    private String fareType;
}
