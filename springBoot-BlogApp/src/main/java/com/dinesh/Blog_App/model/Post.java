package com.dinesh.Blog_App.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Post {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;

	    private String content;

	    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Comment> comments;

		
		public Long getId() {
			return id;
		}

		
		public void setId(Long id) {
			this.id = id;
		}

		
		public String getTitle() {
			return title;
		}

		
		public void setTitle(String title) {
			this.title = title;
		}

		
		public String getContent() {
			return content;
		}

		
		public void setContent(String content) {
			this.content = content;
		}

		
		public Set<Comment> getComments() {
			return comments;
		}

		
		public void setComments(Set<Comment> comments) {
			this.comments = comments;
		}
	    
	    
}
