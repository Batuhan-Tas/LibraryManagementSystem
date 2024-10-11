package com.library.LibraryManagementSystem.controller;

import com.library.LibraryManagementSystem.dao.UserRepository;
import com.library.LibraryManagementSystem.model.User;
import com.library.LibraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> find(){
        return userService.get();
    }

    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{name}")
    public List<User> getByName(@PathVariable String name){
        return userService.getByName(name);
    }

    @PutMapping("/")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable int id){
        userService.delete(id);
        return null;
    }



}
