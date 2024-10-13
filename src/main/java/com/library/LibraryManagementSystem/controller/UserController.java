package com.library.LibraryManagementSystem.controller;

import com.library.LibraryManagementSystem.dao.UserRepository;
import com.library.LibraryManagementSystem.model.Books;
import com.library.LibraryManagementSystem.model.Role;
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
    public User delete(@PathVariable int id) throws Exception{
        User user = userService.findById(id);

        if(user.getRole().equals(Role.ADMIN)){
            throw new Exception("Action not allowed. Administrators can not be removed.");
        }else{
            userService.delete(id);
        }

        return null;
    }

    @PostMapping("/lendBook/{userId}")
    public User lendBook(@RequestBody Books book, @PathVariable int userId){
        User user = userService.findById(userId);
        book.setUser(user);
        user.lendBook(book);
        return userService.save(user);
    }

    @PostMapping("/returnBook/{userId}")
    public User returnBook(@RequestBody Books book, @PathVariable int userId){
        User user = userService.findById(userId);
        book.setUser(null);
        user.returnBook();
        return userService.save(user);
    }



}
