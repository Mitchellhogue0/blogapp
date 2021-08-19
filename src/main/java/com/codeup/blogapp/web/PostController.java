package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    @GetMapping
    private List<Post> getPosts() {

        User user = new User(1L, "testy", "testy@test.com", "test123", null);

        List<Category> categories = new ArrayList<>() {{
            add(new Category(1L, "Spring boot"));
            add(new Category(2L, "Why sJS views make my head hurt"));
        }};

        return new ArrayList<Post>() {{
            add(new Post(1L, "new post", "this is some content", user, categories));
            add(new Post(2L, "newer post", "this is somemore content", user, categories));
            add(new Post(3L, "newest post", "this is somemost content", user, categories));
        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        User user = new User(1L, "testy", "testy@test.com", "test123", null);
        if (id == 1) {
            return new Post(1L, "new post", "this is some content", user, null);
        } else {
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post post) {
        System.out.println(post.getTitle());
        System.out.println(post.getContent());
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
    }

}
