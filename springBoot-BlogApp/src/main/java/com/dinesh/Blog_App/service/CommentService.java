package com.dinesh.Blog_App.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dinesh.Blog_App.model.Comment;
import com.dinesh.Blog_App.model.Post;
import com.dinesh.Blog_App.repository.CommentRepository;
import com.dinesh.Blog_App.repository.PostRepository;

@Service
public class CommentService {
	
	 @Autowired
	    private PostRepository postRepository;

	    @Autowired
	    private CommentRepository commentRepository;

	    @Transactional
	    public boolean addComment(Long postId, String content) {
	        Optional<Post> postOptional = postRepository.findById(postId);
	        if (postOptional.isEmpty()) {
	            return false;
	        }
	        Post post = postOptional.get();
	        Comment comment = new Comment();
	        comment.setContent(content);
	        comment.setCreatedAt(LocalDateTime.now());
	        comment.setPost(post);
	        commentRepository.save(comment);
	        return true;
	

	    }

	    public List<Comment> getComments(Long postId) {
	        // Check if the post exists
	        Optional<Post> postOptional = postRepository.findById(postId);
	        if (postOptional.isEmpty()) {
	            return List.of(); // Return an empty list if the post does not exist
	        }
	        
	        // Retrieve and sort comments by creation date in descending order
	        return commentRepository.findByPostIdOrderByCreatedAtDesc(postId);
	    }

		
}
