package com.example.oauth2.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

    @GetMapping("/") // In GitHub registration, the redirect url as localhost:8080, when redirect happen, it'll come here and display html file
    public String main(OAuth2AuthenticationToken token) {

        // After successful login, print all the details that get from GitHub like name, email, repository details from GitHub OAuth2 server
        System.out.println(token.getPrincipal());

        // Assume this file is protected resources stay inside my sever, if someone want to use this, they have to complete the login into my application using GitHub OAuth2
        return "secure.html";
    }
}
