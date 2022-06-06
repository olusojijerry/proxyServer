package com.zenithbank.integration.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class CustomConfig extends WebMvcConfigurationSupport {

    @Bean
    public BasicAccessAuthenticationResolver resolver(){
        return new BasicAccessAuthenticationResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> args){
        args.add(resolver());
        args.add(new PageableHandlerMethodArgumentResolver());
    }
}
