package com.dinesh.Blog_App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.Blog_App.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
