package com.zenithbank.integration.externalintegratiion;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class WakanowFeignClientConfiguration {
    @Value("${core.wakanow.username}")
    private String username;
    @Value("${core.wakanow.password}")
    private String password;

    @Autowired
    @Qualifier("wakanowRestTemplate")
    RestTemplate restTemplate;
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
//        return new BasicAuthRequestInterceptor(username, password, Charset.forName("UTF-8"));
//    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            requestTemplate.header("Authorization", "bearer " + getAccessToken());
        };
    }

    private String getAccessToken() {
        //todo create method to get token from the baseUrl and login details;
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", username);
        map.add("password", password);
        map.add("grant_type", "password");

        HttpEntity<MultiValueMap<String, String>> reqEntity = new HttpEntity<>(map, headers);

        ResponseEntity<Map<String, Object>> response = restTemplate.exchange("https://wakanow-api-affiliate-b2b-devtest-test.azurewebsites.net/token",
                HttpMethod.POST, reqEntity,
                new ParameterizedTypeReference<Map<String, Object>>(){});

        Map<String, Object> obj = response.getBody();

        return obj.get("access_token").toString();
    }
}
