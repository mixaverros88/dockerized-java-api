package com.verros.resources;

import com.verros.messageModel.Message;
import com.verros.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.stream.events.Comment;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
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
    public Response addMessage(@Context UriInfo uriInfo, Message message) throws URISyntaxException {
        Message newMessage =  messageService.addMessage(message);
       return Response.created(new URI(uriInfo.getAbsolutePath().toString() + "/"  + newMessage.getId()))
               .entity(newMessage)
               .build();

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
        message.addLink(getUriForSelf(uriInfo, message), "self");
        message.addLink(getUriForProfile(uriInfo, message), "profile");
        return message;
    }

    @Path("/{id}/comments")
    public CommentsResources getCommentRecources(@PathParam("id") long id){
        return new CommentsResources();
    }


    @Path("/test")
    @HEAD
    public Response getHeader(){
        return Response
                .status(Response.Status.OK)
                .expires(new Date())
                .header("someHeader", "someHeaderValue")
                .build();
    }


    public String getUriForSelf(@Context UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                    .path(MessagesResources.class)
                    .path(Long.toString(message.getId()))
                    .build()
                    .toString();
    }

    public String getUriForProfile(@Context UriInfo uriInfo,  Message message){
        return uriInfo.getBaseUriBuilder()
                .path(ProfileResources.class)
                .path(message.getAuthor())
                .build()
                .toString();
    }


}
