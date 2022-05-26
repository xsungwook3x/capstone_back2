package com.example.server2.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Collections;

@Slf4j
@Service
public class EmergencyService {

    public void sendEmergencyMessage(Long townId){
        String BASE_URL = "http://3.39.183.150:8080/api/message/emergency/";
        BASE_URL+=townId;

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(BASE_URL);

        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient client = WebClient.builder()
                .baseUrl(BASE_URL)
                .uriBuilderFactory(factory)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        String response = client.get().retrieve().bodyToMono(String.class).block();


    }
}
