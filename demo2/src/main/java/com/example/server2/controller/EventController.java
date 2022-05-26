package com.example.server2.controller;

import com.example.server2.StatusEnum;
import com.example.server2.dto.EventDTO;
import com.example.server2.dto.StatusDTO;
import com.example.server2.dto.TerminalDTO;
import com.example.server2.model.EventEntity;
import com.example.server2.model.TerminalEntity;
import com.example.server2.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/{town_id}")
    public ResponseEntity<?> findEventsByTownId(@PathVariable Long town_id){
        try {
            List<EventEntity> entities = eventService.retrieveEventsByTownId(town_id);
            List<EventDTO> dtos = entities.stream().map(EventDTO::new).collect(Collectors.toList());

            HttpHeaders headers= new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

            StatusDTO message = new StatusDTO();
            message.setStatus(StatusEnum.OK);
            message.setMessage("성공 코드");
            message.setData(dtos);

            return new ResponseEntity<>(message,headers, HttpStatus.OK);
        }catch (Exception e){
            String error = e.getMessage();
            StatusDTO message = new StatusDTO();
            message.setStatus(StatusEnum.BAD_REQUEST);
            message.setMessage("실패 코드");
            message.setData(error);
            return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
        }
    }
}
