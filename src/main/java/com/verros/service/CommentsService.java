package com.verros.service;

import com.verros.database.DatabaseClass;
import com.verros.messageModel.Comment;
import com.verros.messageModel.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentsService {

    private Map<Long, Message> message = DatabaseClass.getMessages();


    public List<Comment> getAllComments(long messageId){
        Map<Long, Comment> comments = message.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }

    public Comment getComment(long messageId, long comentId){
        Map<Long, Comment> comments = message.get(messageId).getComments();
        return  comments.get(comentId);
    }

    public Comment addComment(long messageId, Comment comment){
        Map<Long, Comment> comments = message.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment){
        Map<Long, Comment> comments = message.get(messageId).getComments();
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId){
        Map<Long, Comment> comments = message.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
