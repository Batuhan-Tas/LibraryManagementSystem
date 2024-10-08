package com.library.LibraryManagementSystem.dao;

import com.library.LibraryManagementSystem.model.User;

import java.util.List;

public interface UserRepository {

    List<User> get();
    User getByName(String name);
    User save(User user);
    User update(User user);
    User delete(String name);

}
