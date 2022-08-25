package org.example.showerargument.service.impl;

import org.example.showerargument.service.ResponseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceNaiveImpl implements ResponseService {


    @Override
    public String respond(List<String> user1Messages, List<String> user2Message) {
        if (user2Message.size() > 1.25 * user1Messages.size()) {
            return respondPetty();
        } else {
            return respondThoughtful();
        }
    }

    private String respondPetty(){
        return "Bitch no you didn't";
    }

    private String respondThoughtful(){
        return "Can you tell me more where you're coming from?";
    }
}
