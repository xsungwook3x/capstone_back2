package com.example.server2.service;

import com.example.server2.model.TerminalInfoEntity;
import com.example.server2.repository.TerminalInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TerminalInfoService {

    @Autowired
    private TerminalInfoRepository terminalInfoRepository;

    public void addTerminalInfo(TerminalInfoEntity entity){
        terminalInfoRepository.save(entity);
    }
}
