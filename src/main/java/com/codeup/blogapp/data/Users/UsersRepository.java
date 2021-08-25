package com.codeup.blogapp.data.Users;

import com.codeup.blogapp.data.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findByEmail(String email);
}
