package com.zenithbank.integration.dto.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FlightModelsD {
    private String airlineLogoUrl;
    private String stopCity;
    private String tripDuration;
    private String stopTime;
    private Long stops;
    private Date arrivalTime;
    private String arrivalCode;
    private String arrivalName;
    private Date departureTime;
    private String departureName;
    private String departureCode;
    private String airlineName;
    private String name;
    private String airline;
    private List<FlightLegD> flightLegs;
    private FreeBaggageD freeBaggage;
}
