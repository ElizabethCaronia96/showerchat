package org.example.showerargument.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@Entity
public class ChatEntity {

    @Id
    @GeneratedValue
    Long chatId;

    @Column
    String username1;
    @Column
    String user2name;
    @Column
    ArrayList user1Messages;
    @Column
    ArrayList user2Messages;
    @Column
    String chatType;


    public ChatEntity updateUser1MessageRecord(String input){
        user1Messages.add(input);
        return this;
    }

    public ChatEntity updateUser2MessageRecord(String input){
        user2Messages.add(input);
        return this;
    }


}
