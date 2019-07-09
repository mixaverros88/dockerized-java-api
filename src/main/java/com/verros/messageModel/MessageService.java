package com.verros.messageModel;

import com.verros.database.DatabaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {
    public static Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService(){
        messages.put( 1L, new Message(1, "hello 1 ", "Mike verros 1 ") );
        messages.put( 2L, new Message(2, "hello 2 ", "Mike verros 2") );
    }

    public List<Message> getAllMessages(){
        return  new ArrayList<Message>(messages.values());
    }

    public Message getMessage(long id){
        return messages.get(id);
    }

    public Message addMessage(Message message){
        message.setId(messages.size() + 1);
        messages.put(message.getId() , message);
        return message;
    }

    public Message updateMessage(Message message){
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
