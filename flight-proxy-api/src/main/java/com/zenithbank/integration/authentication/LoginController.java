package com.zenithbank.integration.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    //this is for the login page.
    @GetMapping("/auth")
    public String login(){
        return "login";
    }
}
