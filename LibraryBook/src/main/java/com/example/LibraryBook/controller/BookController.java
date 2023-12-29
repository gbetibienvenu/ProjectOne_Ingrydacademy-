package com.example.LibraryBook.controller;

import com.example.LibraryBook.model.BookModel;
import com.example.LibraryBook.model.BorrowedBookModel;
import com.example.LibraryBook.model.UserModel;
import com.example.LibraryBook.service.BorrowedBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class BookController {
    @Autowired
    private BorrowedBookService borrowedBookService;

    @PostMapping("/users")
    public ResponseEntity< BookModel> saveBook(@Valid @RequestBody BookModel bookModel){
        return  new ResponseEntity<>(bookService.saveUsers(bookModel),HttpStatus.CREATED);
    }
    @PostMapping("/Allbooks")
    public Map<String,Boolean> saveAllBooks(@Valid @RequestBody List<BookModel> bookModel){
        return  bookModel.saveAllUsers(bookModel);
    }
    @GetMapping("/users")
    public ResponseEntity<List<BookModel>> getAllUser (){
        return  ResponseEntity.ok(bookService.getAll());
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<BookModel> getUserById(@PathVariable long id){
        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.OK);

    }
    @PutMapping("users/{id}")
    public ResponseEntity<String> updateUser(@Valid @PathVariable long id, @RequestBody BookModel bookModel){
        return ResponseEntity.ok(bookService.updateUser(id, bookModel));
    }
    @DeleteMapping("users/{id}")
    public  ResponseEntity<BookModel> deleteuser (@PathVariable long id){
        return ResponseEntity.ok(bookService.deleteById(id));
    }

}
