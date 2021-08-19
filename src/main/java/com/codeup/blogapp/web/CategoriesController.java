package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping(value="/api/categories", headers = "accept=application/json")
public class CategoriesController {

    User user = new User(1L, "testy", "testy@test.com", "test123", null);

    Collection<Post> userPosts = new ArrayList<>() {{
        add(new Post(1L, "post1", "this some post1", user, null));
        add(new Post(2L, "post2", "this some post2", user, null));
        add(new Post(3L, "post3", "this some post3", user, null));
    }};


    @GetMapping
    private Category getPostsByCategory(@RequestParam String categoryName) {

        Category category = new Category(1L, "Tech");

        category.setPosts(userPosts);

        return category;
    }



}
