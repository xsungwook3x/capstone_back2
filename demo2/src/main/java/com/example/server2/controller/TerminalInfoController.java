package com.example.server2.controller;

import com.example.server2.StatusEnum;
import com.example.server2.dto.StatusDTO;
import com.example.server2.dto.TerminalInfoDTO;
import com.example.server2.model.TerminalInfoEntity;
import com.example.server2.service.TerminalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/terminal_info")
public class TerminalInfoController {

    @Autowired
    private TerminalInfoService terminalInfoService;

    @PostMapping
    public ResponseEntity<?> putTerminalInfo(@RequestBody TerminalInfoDTO dto){
        try {
            TerminalInfoEntity entity = TerminalInfoDTO.toEntity(dto);

            entity.setId(null);

            ZonedDateTime nowUTC =ZonedDateTime.now(ZoneId.of("UTC"));

            LocalDateTime currentDateTime =nowUTC.withZoneSameInstant(ZoneId.of("Asia/Seoul")).toLocalDateTime().withNano(0);

            currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            entity.setTime(currentDateTime);

            terminalInfoService.addTerminalInfo(entity);

            HttpHeaders headers= new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

            StatusDTO message = new StatusDTO();
            message.setStatus(StatusEnum.OK);
            message.setMessage("성공 코드");
;

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
