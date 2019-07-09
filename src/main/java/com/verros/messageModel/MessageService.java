package com.verros.messageModel;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<Message> getAllMessages(){
        Message m1 = new Message(1, "Hello wordl 1", "Mike verros ");
        Message m2 = new Message(2, "Hello wordl 2", "George verros");
        Message m3 = new Message(3, "Hello wordl 3", "verros");

        List<Message> list  = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);

        return list;
    }
}
