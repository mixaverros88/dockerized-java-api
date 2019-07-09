package com.verros.database;

import com.verros.messageModel.Message;
import com.verros.messageModel.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

    public static Map<Long, Message> messages = new HashMap<>();
    public static Map<Long, Profile> profiles = new HashMap<>();


    public static Map<Long, Message> getMessages(){
        return  messages;
    }

    public static Map<Long, Profile> getProfile(){
        return  profiles;
    }
}
