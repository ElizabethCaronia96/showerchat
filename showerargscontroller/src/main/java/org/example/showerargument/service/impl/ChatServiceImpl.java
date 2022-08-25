package org.example.showerargument.service.impl;

import org.example.showerargument.model.AuditRepo;
import org.example.showerargument.model.ChatEntity;
import org.example.showerargument.model.ChatSessionEvents;
import org.example.showerargument.model.ChatStartEvent;
import org.example.showerargument.service.ChatService;
import org.example.showerargument.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChatServiceImpl implements ChatService {

    Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    AuditRepo auditRepo;

    @Autowired
    ResponseService responseService;

    public ChatSessionEvents startAChatSession(ChatStartEvent chatSessionDetails) {
        // turn on session
        chatSessionDetails.setActive(true);

        // log into db details learned so far
        Long id = auditRepo.save(chatSessionDetails.getChatEntity()).getChatId();
        logger.info("== New Chat between {} and {} saved into db ==", chatSessionDetails.getChatEntity().getUsername1(), chatSessionDetails.getChatEntity().getUser2name());

        chatSessionDetails.setChatId(id);
        return chatSessionDetails;
    }

    @Override
    public String onUser1Input(String input, Long chatId) {

        // update the audit record
        ChatEntity chatEntity = auditRepo.findById(chatId).get();
        chatEntity.updateUser1MessageRecord(input);
        auditRepo.save(chatEntity);
        logger.info("==Updated the chat record for {} in chat {}==", chatEntity.getUsername1(), chatId);

        // generate a response
        String response = responseService.respond(chatEntity.getUser1Messages(), chatEntity.getUser2Messages());

        // update the audit record again, MVP assume no one's touched the db table
        chatEntity.updateUser2MessageRecord(response);
        auditRepo.save(chatEntity);

        // finally, return to controller
        return response;
    }
}
