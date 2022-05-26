package com.example.server2.service;

import com.example.server2.model.EventEntity;
import com.example.server2.repository.EventRepostiory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EventService {

    @Autowired
    private EventRepostiory eventRepostiory;

    public List<EventEntity> retrieveEventsByTownId(Long townId){
        return eventRepostiory.findByTownId(townId);
    }
}
