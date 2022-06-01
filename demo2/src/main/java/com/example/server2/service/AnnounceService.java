package com.example.server2.service;

import com.example.server2.dto.AnnounceDTO;
import com.example.server2.dto.MessageDTO;
import com.example.server2.model.AnnounceEntity;
import com.example.server2.repository.AnnounceRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class AnnounceService {

    @Autowired
    private AnnounceRepository announceRepository;

    public void addAnnounce(MessageDTO dto){

        LocalDate currentDate = LocalDate.now();

        AnnounceEntity entity =new AnnounceEntity();
        entity.setId(null);
        entity.setContent(dto.getContent());
        entity.setTownId(dto.getTownId());
        entity.setCreatedDate(currentDate);

        announceRepository.save(entity);
    }
}
