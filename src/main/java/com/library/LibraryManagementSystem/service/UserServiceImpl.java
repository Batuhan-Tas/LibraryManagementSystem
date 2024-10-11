package com.library.LibraryManagementSystem.service;

import com.library.LibraryManagementSystem.dao.UserRepository;
import com.library.LibraryManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByName(String name) {
        return userRepository.getByName(name);
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);

    }
}
