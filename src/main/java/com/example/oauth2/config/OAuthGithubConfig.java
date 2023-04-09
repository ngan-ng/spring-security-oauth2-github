package com.example.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;

public class OAuthGithubConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // any request inside this application has to be authenticated. Login type want to use is OAuth2 login.
        http.authorizeHttpRequests().anyRequest().authenticated().and().oauth2Login();
        return http.build();
    }

    // 3 ways to register Client details. Last way in properties file.

    // First: Common Auth server on the market
    // Send Client id, Client secret to Auth server, tell application, which Auth server using
    private ClientRegistration clientRegistration() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("5f187f9c5f43ea4edd0d")
                .clientSecret("b46c696c00272420a787b36bb90faa295d211aa8")
                .build();
    }

    // Once you have ClientRegistration value, should create ClientRegistrationRepository - same as UserDetails
    @Bean
    public ClientRegistrationRepository clientRepository() {
        ClientRegistration clientReg = clientRegistration();
        return new InMemoryClientRegistrationRepository(clientReg);
    }


    // Second: a lot of configuration, most don't use this. Useful when you're building the Auth server inside your organization
//    private ClientRegistration clientRegistration() {
//        ClientRegistration cr = ClientRegistration.withRegistrationId("github") // which Auth server going to use
//                .clientId("5f187f9c5f43ea4edd0d")
//                .clientSecret("b46c696c00272420a787b36bb90faa295d211aa8")
//                .scope(new String[] { "read:user" })
//                .authorizationUri("https://github.com/login/oauth/authorize") // endpoint of Auth server belong to GitHub
//                .tokenUri("https://github.com/login/oauth/access_token") // to get access token
//                .userInfoUri("https://api.github.com/user") // get details of user
//                .userNameAttributeName("id")
//                .clientName("GitHub") // client name that giving for Client application in GitHub website
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE) // which grant type going to use
//                .redirectUri("{baseUrl}/{action}/oauth2/code/{registrationId}")
//                .build();
//        return cr;
//    }



}



