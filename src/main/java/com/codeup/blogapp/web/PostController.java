package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

@RestController
@RequestMapping(value = "/api/posts", headers="Accept=application/json")
public class PostController {

    @GetMapping
    private List<Post> getPosts(){
        return new ArrayList<Post>(){{
            add(new Post(1L, "new post", "this is some content"));
            add(new Post(2L, "newer post", "this is somemore content"));
            add(new Post(3L, "newest post", "this is somemost content"));
        }};
    }

    @GetMapping("{id}")
    private Post getPostById (@PathVariable Long id) {
        if (id == 1) {
            return new Post(1L, "new post", "this is some content");
        } else {
            return null;
        }
    }


}
