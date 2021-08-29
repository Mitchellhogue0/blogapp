package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Posts.Post;
import com.codeup.blogapp.data.Posts.PostsRepository;
import com.codeup.blogapp.data.Users.User;
import com.codeup.blogapp.data.Users.UsersRepository;
import com.codeup.blogapp.security.OAuthConfiguration;
import com.codeup.blogapp.services.EmailService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    private final PostsRepository postsRepository;

    private final EmailService emailService;

    private final UsersRepository usersRepository;


    public PostController(PostsRepository postsRepository, EmailService emailService, UsersRepository usersRepository){
        this.postsRepository = postsRepository;
        this.emailService = emailService;
        this.usersRepository = usersRepository;
    }


    @GetMapping
    private List<Post> getPosts() {
       return postsRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        return postsRepository.findById(id).get();
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost, OAuth2Authentication auth) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        String email = auth.getName();
        User user = usersRepository.findByEmail(email).get();
        newPost.setUser(user);
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
