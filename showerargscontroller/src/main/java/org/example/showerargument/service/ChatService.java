package org.example.showerargument.service;

import org.example.showerargument.model.ChatSessionEvents;
import org.example.showerargument.model.ChatStartEvent;

public interface ChatService {
    public ChatSessionEvents startAChatSession(ChatStartEvent chatSessionDetails);

    public String onUser1Input(String input, Long id);
}
