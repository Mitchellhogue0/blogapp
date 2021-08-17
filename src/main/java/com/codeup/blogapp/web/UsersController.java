package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
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
        System.out.println(newUser.getRole());
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id) {
    }

    @GetMapping("{id}")
    private User findById(@PathVariable Long id) {
        return getUsers().stream()
                .filter(t ->
                 id.equals(t.getId())).findFirst().orElse(null);
    }

    @GetMapping("/findByUsername")
    private User findByUsername(@RequestParam String username) {
        return getUsers().stream().filter(t ->
                username.equals(t.getUsername())).findFirst().orElse(null);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email) {
        return getUsers().stream().filter(t ->
                email.equals(t.getEmail())).findFirst().orElse(null);
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword( @PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
        System.out.println(oldPassword);
        System.out.println(newPassword);
    }

    @PutMapping("{username}/updatePassword")
    private void updatePassword(@RequestParam String username, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
        System.out.println(oldPassword);
        System.out.println(newPassword);
    }
}
