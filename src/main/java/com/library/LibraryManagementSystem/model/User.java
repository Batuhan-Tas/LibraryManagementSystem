package com.library.LibraryManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="user",schema = "library")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private int password;

    @Column(name = "is_banned")
    private boolean isBanned;

    @Enumerated(EnumType.STRING)
    private Role role;

    //Bi-directional

    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Books> books;

    public void lendBook(Books book){
        if(books == null){
            books = new ArrayList<>();
        }
        books.add(book);
    }

    public void returnBook(){
        books = new ArrayList<>();

    }





}
