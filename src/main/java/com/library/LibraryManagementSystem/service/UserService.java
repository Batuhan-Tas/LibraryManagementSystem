package com.library.LibraryManagementSystem.service;

import com.library.LibraryManagementSystem.model.Books;
import com.library.LibraryManagementSystem.model.User;

import java.util.List;

public interface UserService {

    List<User> get();
    List<User> getByName(String name);
    User save(User user);
    User update(User user);
    void delete(int id);
    User findById(int id);

}
