package com.library.LibraryManagementSystem.model;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String name;
    private int password;
    private String role;

    public User(){

    }

    public User(String name,int password,String role){
        this.name=name;
        this.password=password;
        this.role=role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
