package com.codeup.blogapp.data.Posts;

import com.codeup.blogapp.data.Posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
