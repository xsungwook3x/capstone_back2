package com.example.server2.controller;

import com.example.server2.StatusEnum;
import com.example.server2.dto.StatusDTO;
import com.example.server2.dto.TerminalInfoDTO;
import com.example.server2.model.TerminalInfoEntity;
import com.example.server2.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/emergency")
public class EmergencyController {

    @Autowired
    private EmergencyService emergencyService;

    @GetMapping("/{town_id}")
    public ResponseEntity<?> sendEmergencyMessage(@PathVariable Long town_id){

        emergencyService.sendEmergencyMessage(town_id);

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        StatusDTO message = new StatusDTO();
        message.setStatus(StatusEnum.OK);
        message.setMessage("성공 코드");


        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }
}
