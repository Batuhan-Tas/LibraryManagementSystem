package com.library.LibraryManagementSystem.dao;

import com.library.LibraryManagementSystem.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Books,Integer> {

    @Query(value = "SELECT * FROM library.books as b WHERE b.genre = genre", nativeQuery = true)
    List<Books> findByGenre(String genre);
}
