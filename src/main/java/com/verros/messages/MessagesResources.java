package com.verros.messages;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/messages")
public class MessagesResources {

    @GET
    public  String getMessages(){
        return "Hello";
    }
}
