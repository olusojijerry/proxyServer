package com.zenithbank.integration.externalintegratiion.wakanow.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.Date;
import java.util.List;

@Data
@Generated("com.robohorse.robopojogenerator")
class PriceDetails {
    @JsonProperty("BaseFare")
    private Price baseFare;
    @JsonProperty("Tax")
    private Price tax;
    @JsonProperty("PassengerType")
    private String passengerType;
}

@Data
@Generated("com.robohorse.robopojogenerator")
public class FlightModels{
    @JsonProperty("AirlineLogoUrl")
    private String airlineLogoUrl;
    @JsonProperty("StopCity")
    private String stopCity;
    @JsonProperty("TripDuration")
    private String tripDuration;
    @JsonProperty("StopTime")
    private String stopTime;
    @JsonProperty("Stops")
    private Long stops;
    @JsonProperty("ArrivalTime")
    private Date arrivalTime;
    @JsonProperty("ArrivalCode")
    private String arrivalCode;
    @JsonProperty("ArrivalName")
    private String arrivalName;
    @JsonProperty("DepartureTime")
    private Date departureTime;
    @JsonProperty("DepartureName")
    private String departureName;
    @JsonProperty("DepartureCode")
    private String departureCode;
    @JsonProperty("AirlineName")
    private String airlineName;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Airline")
    private String airline;
    @JsonProperty("FlightLegs")
    private List<FlightLeg> flightLegs;
    @JsonProperty("FreeBaggage")
    private FreeBaggage freeBaggage;
}
