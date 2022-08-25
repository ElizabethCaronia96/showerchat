package org.example.showerargument.model;

import lombok.Data;

@Data
public class ChatSessionEvents {

    String message;
    Long chatId;
    String token;
    boolean active;
}
