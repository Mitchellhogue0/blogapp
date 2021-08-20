package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.PostsRepository;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    private final PostsRepository postsRepository;

    public PostController(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }


    @GetMapping
    private List<Post> getPosts() {
       return postsRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        return postsRepository.getById(id);
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postsRepository.save(newPost);
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post post) {
        System.out.println(post.getTitle());
        System.out.println(post.getContent());
        postsRepository.save(post);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        postsRepository.deleteById(id);
    }

}
