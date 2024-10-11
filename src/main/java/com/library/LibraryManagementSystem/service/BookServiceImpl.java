package com.library.LibraryManagementSystem.service;

import com.library.LibraryManagementSystem.dao.BookRepository;
import com.library.LibraryManagementSystem.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Books> find() {
        return bookRepository.findAll();
    }

    @Override
    public Books findById(int id) {
        Optional<Books> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }

    @Override
    public Books save(Books book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Books update(Books book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Books> findByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
}
