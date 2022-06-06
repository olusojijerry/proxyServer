package com.zenithbank.integration.externalintegratiion.wakanow;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenithbank.integration.externalintegratiion.wakanow.config.Api;
import com.zenithbank.integration.externalintegratiion.wakanow.config.WakanowInfoConfig;
import com.zenithbank.integration.externalintegratiion.wakanow.pojo.FlightSerchResponse;
import com.zenithbank.integration.externalintegratiion.wakanow.requestPojo.SearchRequest;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WakanowIntegrationServiceImpl implements WakanowIntegrationService{
    private RestTemplate restTemplate;
    private WakanowInfoConfig wakanowInfoConfig;

    public WakanowIntegrationServiceImpl(@Qualifier("wakanowRestTemplate")RestTemplate restTemplate,
                                         WakanowInfoConfig wakanowInfoConfig) {
        this.restTemplate = restTemplate;
        this.wakanowInfoConfig = wakanowInfoConfig;
    }

    @Override
    public HttpEntity<byte[]> getAirports() {
        return null;
    }

    @Override
    public List<FlightSerchResponse> searchFlight(SearchRequest request) throws JsonProcessingException {
        HttpHeaders headers = createHeaders("", "");

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(request);

        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

        Api api = wakanowInfoConfig.getApi();

        ResponseEntity<List<FlightSerchResponse>> response = restTemplate
                .exchange(api.getFlightSearch(), HttpMethod.POST, requestEntity,
                        new ParameterizedTypeReference<List<FlightSerchResponse>>() {}, new HashMap<>());

        return response.getBody();
    }



    //manual management of the authorization HTTP Header
    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders(){{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }
}
