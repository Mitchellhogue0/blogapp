package com.codeup.blogapp.data.Users;

import com.codeup.blogapp.data.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}