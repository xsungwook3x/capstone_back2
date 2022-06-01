package com.example.server2.handler;

import com.example.server2.dto.MessageDTO;
import com.example.server2.service.AnnounceService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class SocketTextHandler extends TextWebSocketHandler {


    private AnnounceService announceService;

    public SocketTextHandler(AnnounceService announceService){
        this.announceService=announceService;
    }
    private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        sessions.add(session);
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        String payload = message.getPayload();
        log.info("payload : {}",payload);
        for(WebSocketSession s: sessions){
            s.sendMessage((new TextMessage(payload)));
        }
        JSONObject jsonObject = new JSONObject(payload);
        log.info("content: {}",jsonObject.getString("content"));
        log.info("townId: {}",jsonObject.getLong("townId"));
        MessageDTO dto = new MessageDTO();
        dto.setTownId(jsonObject.getLong("townId"));
        dto.setContent(jsonObject.getString("content"));
        announceService.addAnnounce(dto);



    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws  Exception{
        sessions.remove(session);
    }

}
