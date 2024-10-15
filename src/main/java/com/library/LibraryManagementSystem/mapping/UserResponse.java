package com.library.LibraryManagementSystem.mapping;

import com.library.LibraryManagementSystem.model.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private int userName;
    private List<Books> booksList;
}
