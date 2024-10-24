package com.library.LibraryManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    public LibraryServiceImpl() {
    }

    @Override
    public String welcome() {
        return "Welcome To The Library!";
    }
}
