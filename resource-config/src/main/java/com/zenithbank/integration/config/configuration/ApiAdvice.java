package com.zenithbank.integration.config.configuration;

import com.zenithbank.integration.config.exception.ApiException;
import com.zenithbank.integration.config.exception.AuthorisationErrorException;
import com.zenithbank.integration.config.pojo.RestResponsePojo;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ApiAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody RestResponsePojo<?> handleMethodArguementException(MethodArgumentNotValidException e, final Model model, HttpServletResponse response){
        log.error("Exception during execution of application " + e.getMessage());

        RestResponsePojo<List<ObjectError>> restPojo = new RestResponsePojo<>();
        log.info(e.getLocalizedMessage());
        BeanPropertyBindingResult beanPropertyBindingResult = (BeanPropertyBindingResult) e.getBindingResult();
        restPojo.setData(beanPropertyBindingResult.getAllErrors());
        restPojo.setMessage("Unable to process request. Check for validation errors.");
        restPojo.setSuccess(Boolean.FALSE);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        return restPojo;
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody RestResponsePojo<?> handleMessageNotReadable(HttpMessageNotReadableException e,
                                                                      final Model model, HttpServletResponse response){
        RestResponsePojo<String> responsePojo = new RestResponsePojo<>();

        e.printStackTrace();
        log.info(e.getLocalizedMessage());
        responsePojo.setMessage("Unreadable message body");
        responsePojo.setSuccess(Boolean.FALSE);
        responsePojo.setData(e.getMessage());

        return responsePojo;
    }

    @ExceptionHandler({ApiException.class, SQLException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody RestResponsePojo<?> handleApiException(ApiException e, final Model model, HttpServletResponse response){
        log.error("Exception during execution of application " + e.getMessage());
        e.printStackTrace();
        RestResponsePojo<String> responsePojo = new RestResponsePojo<>();
        log.info(e.getLocalizedMessage());
        responsePojo.setMessage(e.getMessage());
        responsePojo.setSuccess(Boolean.FALSE);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        return responsePojo;
    }

    @ExceptionHandler({FeignException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody RestResponsePojo<?> feignClientException(FeignException e,
                                                                  final Model model, HttpServletResponse response){
        RestResponsePojo<ObjectError> restResponsePojo = new RestResponsePojo<>();

        log.info(e.getLocalizedMessage());
        e.printStackTrace();

        restResponsePojo.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        restResponsePojo.setMessage("Failed Connection To Client " + e.getMessage());
        restResponsePojo.setSuccess(Boolean.FALSE);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        return restResponsePojo;
    }

    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody RestResponsePojo<?> authenticationErrorHandler(AuthenticationException e, final Model model,
                                                                        HttpServletResponse response){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();

        log.info(e.getLocalizedMessage());
        e.printStackTrace();

        restResponsePojo.setSuccess(Boolean.FALSE);
        restResponsePojo.setMessage(e.getMessage());
        restResponsePojo.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        return restResponsePojo;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody RestResponsePojo<?> handleException(Exception e, final Model model, HttpServletResponse response){
        RestResponsePojo<String> responsePojo = new RestResponsePojo<>();

        e.printStackTrace();
        log.info(e.getLocalizedMessage());

        responsePojo.setMessage("Unable to process request at the moment | " + e.getMessage());
        responsePojo.setSuccess(Boolean.FALSE);
        responsePojo.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        return responsePojo;
    }
}

