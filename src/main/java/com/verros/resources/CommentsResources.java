package com.verros.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentsResources {

    @GET
    public String get(){
        return "test";
    }

    @GET
    @Path("/{commentId}")
    public String getCommentId(@PathParam("messageId") long messageId ,@PathParam("commentId") long commentId){
        return "messageId " + messageId + "  commentId " + commentId;
    }

}
