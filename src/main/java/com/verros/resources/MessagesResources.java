package com.verros.resources;

import com.verros.messageModel.Message;
import com.verros.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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

        if(message.getAuthor() == null || message.getMessage() == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The author and the message fields are required")
                    .build();
        }

        Message newMessage =  messageService.addMessage(message);

       return Response.created(new URI(uriInfo.getAbsolutePath().toString() + "/"  + newMessage.getId()))
               .entity(newMessage)
               .build();
    }

    @PUT
    @Path("/{messageId}")
    public Response putMessage(@PathParam("messageId") long id, Message message){

        if(id<=0){
            return Response.status(Response.
                    Status.BAD_REQUEST)
                    .entity("Please provide a valid id")
                    .build();
        }

        if ( !messageService.getAllMessages().contains(message) ){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Message id: " + id + " doesn't exists")
                    .build();
        }

        message.setId(id);
        messageService.updateMessage(message);
        return Response.status(Response.Status.CREATED)
                .entity(message)
                .build();
    }


    @DELETE
    @Path("/{messageId}")
    public Response deleteMessage(@PathParam("messageId") long id){
        messageService.removeMessage(id);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{messageId}")
    @Produces({"application/json", "application/xml"})
    public Response getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo){

        if(id<=0){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Please provide a valid id")
                    .build();
        }
        if(messageService.getMessage(id) == null){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Message id: " + id + " doesn't exists")
                    .build();
        }

        Message  message = messageService.getMessage(id);
        message.addLink(getUriForSelf(uriInfo, message), "self");
        message.addLink(getUriForProfile(uriInfo, message), "profile");

        return Response.status(Response.Status.OK)
                .entity(message)
                .build();
    }

    @Path("/{messageId}/comments")
    public CommentsResources getCommentRecources(@PathParam("messageId") long id){
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
