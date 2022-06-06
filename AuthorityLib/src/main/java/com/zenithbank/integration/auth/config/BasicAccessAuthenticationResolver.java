package com.zenithbank.integration.auth.config;

import com.zenithbank.integration.auth.annotation.Auth;
import com.zenithbank.integration.auth.authorisation.BasicAccessAuthenticationHandler;
import com.zenithbank.integration.entity.flight.CoreUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static org.springframework.web.bind.support.WebArgumentResolver.UNRESOLVED;

public class BasicAccessAuthenticationResolver implements HandlerMethodArgumentResolver {
    @Autowired
    BasicAccessAuthenticationHandler basicAccessAuthenticationHandler;
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(Auth.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        if(parameter.getParameterType() == CoreUser.class){
            return basicAccessAuthenticationHandler.getUser(webRequest);
        }

        return UNRESOLVED;
    }
}
