package com.example.LibraryBook.service;

import com.example.LibraryBook.model.BookModel;
import com.example.LibraryBook.model.UserModel;
import com.example.LibraryBook.repository.BookRepository;
import com.example.LibraryBook.repository.UserRepository;
import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;

import java.awt.print.Book;
import java.util.List;

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Cacheable("getAllBooks")
    public List<BookModel> getAllBooks(){
        return bookRepository.findAll();
    }
    @CacheEvict(value = {"getAllBook", "getBookById"}, allEntries = true)
    public void addBook(Book book){
       bookRepository.save(book);
    }
    @CacheEvict (value = {"getAllBook", "getBookById"}, allEntries = true)
    public void deleteBook(Long  bookId){
        bookRepository.deleteById(bookId);
    }
    public BookModel findBookById(Long bookId){
        return bookRepository.findById(bookId).orElse(null);
    }
    public BookModel findBookByIsbn(String isbn){
        return bookRepository.findUserByIsbn(isbn);
    }
    public BookModel findByTitle(String title){
        return bookRepository.findByTitle(title);

    }

}
