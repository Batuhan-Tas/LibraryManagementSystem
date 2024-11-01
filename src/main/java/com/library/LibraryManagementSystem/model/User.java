package com.library.LibraryManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.lang.reflect.Array;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="user",schema = "library")
public class User implements UserDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;





    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", schema = "library", joinColumns = {@JoinColumn(name="user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> authorities = new HashSet<>();
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

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
