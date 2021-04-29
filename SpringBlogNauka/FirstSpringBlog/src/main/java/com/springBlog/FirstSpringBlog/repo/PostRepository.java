package com.springBlog.FirstSpringBlog.repo;

import com.springBlog.FirstSpringBlog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
