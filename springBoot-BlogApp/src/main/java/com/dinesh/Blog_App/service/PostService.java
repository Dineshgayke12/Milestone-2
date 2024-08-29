package com.dinesh.Blog_App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.Blog_App.model.Post;
import com.dinesh.Blog_App.repository.PostRepository;

@Service
public class PostService {

	@Autowired
    private PostRepository postRepository;
	
	 public Post createPost(Post post) {
	        return postRepository.save(post);
	    }
	 
	 public Optional<Post> getPostById(Long id) {
	        return postRepository.findById(id);
	    }
	 
	 public List<Post> getAllPosts() {
	        return postRepository.findAll();
	    }
	 
	 public Optional<Post> updatePost(Long id, Post post) {
	        if (postRepository.existsById(id)) {
	            post.setId(id);
	            return Optional.of(postRepository.save(post));
	        }
	        return Optional.empty();
	    }
	 
	 public void deletePost(Long id) {
	        postRepository.deleteById(id);
	    }
}
