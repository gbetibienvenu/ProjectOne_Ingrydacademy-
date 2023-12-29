package com.example.LibraryBook.controller;

import com.example.LibraryBook.model.BorrowedBookModel;
import com.example.LibraryBook.model.UserModel;
import com.example.LibraryBook.service.BorrowedBookService;
import com.example.LibraryBook.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v1")
public class BorrowedBookController {
    @Autowired
    private BorrowedBookService borrowedBookService;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@Valid @RequestBody BorrowedBookModel borrowedBookModel){
        return  new ResponseEntity<>(borrowedBookService.saveUsers(borrowedBookModel), HttpStatus.CREATED);
    }
    @PostMapping("/Allusers")
    public Map<String,Boolean> saveAllUsers(@Valid @RequestBody List<BorrowedBookModel> borrowedBookModel){
        return  borrowedBookModel.saveAllUsers(borrowedBookModel);
    }
    @GetMapping("/users")
    public ResponseEntity<List<BorrowedBookModel>> getAllUser (){
        return  ResponseEntity.ok(borrowedBookService.getAll());
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable long id){
        return new ResponseEntity<>(borrowedBookService.findUserById(id), HttpStatus.OK);

    }
    @PutMapping("users/{id}")
    public ResponseEntity<String> updateUser(@Valid @PathVariable long id, @RequestBody BorrowedBookModel borrowedBookModel){
        return ResponseEntity.ok(borrowedBookService.updateUser(id, borrowedBookModel));
    }
    @DeleteMapping("users/{id}")
    public  ResponseEntity<BorrowedBookModel> deleteuser (@PathVariable long id){
        return ResponseEntity.ok(borrowedBookService.deleteById(id));
    }

}
