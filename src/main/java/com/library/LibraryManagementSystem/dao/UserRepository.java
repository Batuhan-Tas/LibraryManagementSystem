package com.library.LibraryManagementSystem.dao;

import com.library.LibraryManagementSystem.model.Books;
import com.library.LibraryManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM library.user as u WHERE u.user_name ILIKE %:name%  ", nativeQuery = true)
    Optional<List> getByName(String name);

}
