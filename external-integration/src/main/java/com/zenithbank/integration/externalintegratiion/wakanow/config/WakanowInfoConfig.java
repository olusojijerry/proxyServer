package com.zenithbank.integration.externalintegratiion.wakanow.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("core.integration.wakanow")
public class WakanowInfoConfig {
    private Boolean useProxy = false;
    private String proxyHost;
    private Integer proxyPort;

    private String baseUrl = "https://wakanow-api-affiliate-b2b-devtest-test.azurewebsites.net/";
    private Api api;

    public Boolean getUseProxy() {
        return useProxy;
    }

    public void setUseProxy(Boolean useProxy) {
        this.useProxy = useProxy;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }
}
