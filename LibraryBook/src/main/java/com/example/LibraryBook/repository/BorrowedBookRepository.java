package com.example.LibraryBook.repository;

import com.example.LibraryBook.model.BookModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBookRepository, Long> {
    BorrowedBookRepository findByBookId(Integer bookId);
    BookRepository findByBookAuthor(String bookAuthor);
    BookRepository findByBookname( String bookname );


    List<BorrowedBookRepository> findByUserId( Integer userId);
}
