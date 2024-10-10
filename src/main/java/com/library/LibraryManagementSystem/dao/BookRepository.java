package com.library.LibraryManagementSystem.dao;

import com.library.LibraryManagementSystem.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books,Integer> {
}
