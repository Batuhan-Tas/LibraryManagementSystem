package com.library.LibraryManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

@Data
@NoArgsConstructor
@Entity
@Table(name="user",schema = "library")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Positive
    private int id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private int password;

    @Column(name = "is_banned")
    private boolean isBanned;

    @Enumerated(EnumType.STRING)
    private Role role;

}
