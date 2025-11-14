package com.daonq1408.springbootsetup.repository;

import com.daonq1408.springbootsetup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDetails> findByMail(String mail);
}
