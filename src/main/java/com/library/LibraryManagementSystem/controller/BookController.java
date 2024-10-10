package com.library.LibraryManagementSystem.controller;

import com.library.LibraryManagementSystem.model.Books;
import com.library.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Books> get(){
        return bookService.find();
    }

    @GetMapping("/{id}")
    public Books book(@PathVariable int id){
        Books book = bookService.findById(id);
        if(book==null){
            //Throw exception 404
        }
        return book;
    }

    @PostMapping("/")
    public Books save(@RequestBody Books book){
        return bookService.save(book);
    }

    @PutMapping("/")
    public Books update(@RequestBody Books book){
        return bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Books book = bookService.findById(id);
        if(book == null){
            //Throw exception 404
        }else{
            bookService.delete(id);
            System.out.println("Deleted successfully");
        }

    }
}
