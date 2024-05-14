package com.swontech.s05.service.domain.logic.common;

import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@ServerEndpoint(value = "/ws")
public class WebSocket {
    private static Set<Session> CLIENTS = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        if (CLIENTS.contains(session)) {
            System.out.println("Session Already Connected > " + session);
        } else {
            System.out.println("New Session > " + session);
            CLIENTS.add(session);
        }
    }

    @OnClose
    public void onClose(Session session) throws Exception {
        System.out.println("Session is Closed : " + session);
        CLIENTS.remove(session);
    }

    @OnMessage
    public void onMessage(String message) throws Exception {
        System.out.println("Session Message > " + message);
        for (Session client : CLIENTS) {
            client.getBasicRemote().sendText(message);
        }
    }
}
