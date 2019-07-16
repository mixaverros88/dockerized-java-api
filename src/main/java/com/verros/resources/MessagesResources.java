package com.verros.resources;

import com.verros.messageModel.Message;
import com.verros.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessagesResources {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.TEXT_XML) // Accept Header
    public List<Message> getXmlMessages( @QueryParam("year") int year,
                                      @QueryParam("start") int start,
                                      @QueryParam("size") int size){
        if(year>0){
            return messageService.getAllMessagerForYear(year);
        }
        if(start > 0 && size > 0 ){
            return messageService.getAllMessagePaginated(start, size);
        }
        return messageService.getAllMessages();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getJsonMessages( @QueryParam("year") int year,
                                      @QueryParam("start") int start,
                                      @QueryParam("size") int size){
        if(year>0){
            return messageService.getAllMessagerForYear(year);
        }
        if(start > 0 && size > 0 ){
            return messageService.getAllMessagePaginated(start, size);
        }
        return messageService.getAllMessages();
    }

    @POST
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{id}")
    public Message putMessage(@PathParam("id") long id, Message message){
        message.setId(id);
        return messageService.updateMessage(message);
    }


    @DELETE
    @Path("/{id}")
    public void deleteMessage(@PathParam("id") long id){
        messageService.removeMessage(id);
    }

    @GET
    @Path("/{id}")
    public Message getMessage(@PathParam("id") long id, @Context UriInfo uriInfo){
        Message  message = messageService.getMessage(id);
        String uri = uriInfo.getBaseUriBuilder()
                .path(MessagesResources.class)
                .path(Long.toString(message.getId()))
                .build()
                .toString();

        message.addLink(uri, "self");
        return message;
    }


}
