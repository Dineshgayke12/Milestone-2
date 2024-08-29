package com.dinesh.Blog_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.Blog_App.model.Comment;
import com.dinesh.Blog_App.service.CommentService;


@RestController
@RequestMapping("/posts")
public class PostController {
	
	 @Autowired
	    private CommentService commentService;

	    @PostMapping("/{id}/comments")
	    public ResponseEntity<Void> addComment(@PathVariable("id") Long postId, @RequestBody String commentText) {
	        boolean isCreated = commentService.addComment(postId, commentText);
	        if (isCreated) {
	            return ResponseEntity.status(HttpStatus.CREATED).build();
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @GetMapping("/{id}/comments")
	    public ResponseEntity<List<Comment>> getComments(@PathVariable("id") Long postId) {
	        List<Comment> comments = commentService.getComments(postId);
	        return ResponseEntity.ok(comments);
	    }
	


}
