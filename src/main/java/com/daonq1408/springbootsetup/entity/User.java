package com.daonq1408.springbootsetup.entity;

import com.daonq1408.springbootsetup.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "mail", length = 75, nullable = false, unique = true)
    private String mail;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "fullName", length = 50)
    private String fullName;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
