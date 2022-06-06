package com.zenithbank.integration.externalintegratiion.wakanow;

import com.zenithbank.integration.externalintegratiion.wakanow.pojo.FlightSerchResponse;
import com.zenithbank.integration.externalintegratiion.wakanow.requestPojo.SearchRequest;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface WakanowIntegrationService {
    HttpEntity<byte[]> getAirports();
    List<FlightSerchResponse> searchFlight(SearchRequest request) throws Exception;

}
