package org.example.showerargument.controller;

import org.example.showerargument.model.ChatSessionEvents;
import org.example.showerargument.model.ChatStartEvent;
import org.example.showerargument.service.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    ChatServiceImpl chatService;

    @GetMapping(path="/", produces = "application/json")
    public String init() {
        return "Hello";
    }

    @PostMapping(path = "/startAChatSession", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public Long start(@Validated @RequestBody ChatStartEvent sessionDetails){
        return chatService.startAChatSession(sessionDetails).getChatId();
    }

    @PostMapping("/onUser1Statement")
    public String user1Statement(@Validated @RequestBody ChatSessionEvents session) {
        return chatService.onUser1Input(session.getMessage(), session.getChatId());
    }

    @PostMapping(path = "/nothappy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public String start(@RequestBody String sessionDetails){
        return "Hello" + sessionDetails;
    }

}
