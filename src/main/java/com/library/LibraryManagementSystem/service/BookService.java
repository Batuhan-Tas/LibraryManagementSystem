package com.library.LibraryManagementSystem.service;

import com.library.LibraryManagementSystem.model.Books;

import java.util.List;

public interface BookService {

    List<Books> find();
    Books findById(int id);
    Books save(Books book);
    Books update(Books book);
    void delete(int id);
}
