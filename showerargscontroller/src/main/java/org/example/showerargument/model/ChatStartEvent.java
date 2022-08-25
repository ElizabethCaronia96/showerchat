package org.example.showerargument.model;

import lombok.Data;

@Data
public class ChatStartEvent extends ChatSessionEvents {

    ChatEntity chatEntity;
}
