package com.zenithbank.integration.externalintegratiion;

import com.zenithbank.integration.externalintegratiion.wakanow.WakanowIntegrationService;
import com.zenithbank.integration.externalintegratiion.wakanow.WakanowIntegrationServiceImpl;
import com.zenithbank.integration.externalintegratiion.wakanow.config.Api;
import com.zenithbank.integration.externalintegratiion.wakanow.config.WakanowInfoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;


@EnableConfigurationProperties(WakanowInfoConfig.class)
@Configuration
@EnableFeignClients(basePackages = {"com.zenithbank.integration.externalintegratiion.feign.client"})
public class WakanowAutoConfiguration {
    @Autowired
    WakanowInfoConfig wakanowInfoConfig;

    @Bean("wakanowRestTemplate")
    public RestTemplate wakanowRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();

        if(wakanowInfoConfig.getApi() == null){
            wakanowInfoConfig.setApi(new Api());
        }

        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(wakanowInfoConfig.getBaseUrl()));

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        if (wakanowInfoConfig.getUseProxy()){
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(wakanowInfoConfig.getProxyHost(),
                    wakanowInfoConfig.getProxyPort()));

            requestFactory.setProxy(proxy);
        }

        return restTemplate;
    }

    @Bean
    public WakanowIntegrationService wakanowIntegrationService(){
        return new WakanowIntegrationServiceImpl(wakanowRestTemplate(), wakanowInfoConfig);
    }

    

}
