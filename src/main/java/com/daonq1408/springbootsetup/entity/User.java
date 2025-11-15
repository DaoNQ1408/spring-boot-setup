package com.daonq1408.springbootsetup.entity;

import com.daonq1408.springbootsetup.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }


    @Override
    public String getUsername() {
        return this.mail;
    }
}
