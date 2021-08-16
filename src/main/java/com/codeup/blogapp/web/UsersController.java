package com.codeup.blogapp.web;

import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    @GetMapping
    private List<User> getUsers() {
        return new ArrayList<User>() {{
            add(new User(1L, "username1", "email1@email.com", "password1"));
            add(new User(2L, "username2", "email2@email.com", "password2"));
            add(new User(3L, "username3", "email3@email.com", "password3"));
        }};
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getId());
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id) {
    }
}
