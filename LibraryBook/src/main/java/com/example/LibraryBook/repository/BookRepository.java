package com.example.LibraryBook.repository;

import com.example.LibraryBook.model.BookModel;
import com.example.LibraryBook.model.UserModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Long> {
    BookModel findUserByISBN(String isbn);
    BookModel findUserByAuthor(String author);

    List<BookModel> findByYearOfPublication(Integer yearOfPublication);

    List<BookModel> findByBook(String book);
}
