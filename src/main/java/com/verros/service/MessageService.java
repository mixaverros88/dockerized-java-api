package com.verros.service;

import com.verros.database.DatabaseClass;
import com.verros.messageModel.Comment;
import com.verros.messageModel.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {
    public static Map<Long, Message> messages = DatabaseClass.getMessages();
    public static Map<Long, Comment> comments = DatabaseClass.getComments();

    public MessageService(){
        messages.put( 1L, new Message(1, "hello 1 ", "Mike verros 1 ") );
        messages.put( 2L, new Message(2, "hello 2 ", "Mike verros 2") );
    }

    public List<Message> getAllMessages(){
        return  new ArrayList<Message>(messages.values());
    }

    public List<Message> getAllMessagerForYear(int year){
        List<Message> messagesForYear = new ArrayList<>();
        Calendar col = Calendar.getInstance();
        for(Message message : messages.values()){
            col.setTime(message.getCreated());
            if( col.get(Calendar.YEAR) == year){
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagePaginated(int start, int size){
        ArrayList<Message> list = new ArrayList<Message>(messages.values());
        if(start + size > list.size()){
            return list;
        }else {
            return list.subList(start, start+size);
        }
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
