package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Users.User;
import com.codeup.blogapp.data.Users.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersController(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    private List<User> getUsers() {
        return usersRepository.findAll();
    }

    @PostMapping("/create")
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getId());
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
        System.out.println(newUser.getRole());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        usersRepository.save(newUser);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());
        usersRepository.save(user);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id) {
        usersRepository.deleteById(id);
    }

    @GetMapping("{id}")
    private User findById(@PathVariable Long id) {
        return usersRepository.findById(id).get();
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
