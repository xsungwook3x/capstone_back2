package com.example.server2.service;

import com.example.server2.model.TerminalEntity;
import com.example.server2.repository.TerminalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TerminalService {

    @Autowired
    private TerminalRepository terminalRepository;

    public Optional<TerminalEntity> findTerminalByPhone(String phone){
        return terminalRepository.findByPhone(phone);
    }
}
