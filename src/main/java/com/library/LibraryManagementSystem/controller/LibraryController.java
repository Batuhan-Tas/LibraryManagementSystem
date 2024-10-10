package com.library.LibraryManagementSystem.controller;

import com.library.LibraryManagementSystem.service.UserRepository;
import com.library.LibraryManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    private UserRepository userRepository; //Connect DAO with Controller

    @Autowired
    public LibraryController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> find(){
        return userRepository.get();
    }

    @PostMapping("/")
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/{name}")
    public User getByName(@PathVariable String name){
        return userRepository.getByName(name);
    }

    @PutMapping("/")
    public User update(@RequestBody User user){
        return userRepository.update(user);
    }

    @DeleteMapping("/{name}")
    public User delete(@PathVariable String name){
        return userRepository.delete(name);
    }



}
