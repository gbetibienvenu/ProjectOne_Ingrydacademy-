package com.example.LibraryBook.controller;

import com.example.LibraryBook.model.UserModel;
import com.example.LibraryBook.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@Valid @RequestBody  UserModel userModel){
        return  new ResponseEntity<>(userService.saveUsers(userModel), HttpStatus.CREATED);
    }
    @PostMapping("/Allusers")
    public Map<String,Boolean> saveAllUsers(@Valid @RequestBody list<UserModel> userModel){
        return  userService.saveAllUsers(userModel);
    }
     @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUser (){
        return  ResponseEntity.ok(userService.getAll());
     }
    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable long id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    @PutMapping("users/{id}")
    public ResponseEntity<String> updateUser(@Valid @PathVariable long id, @RequestBody UserModel userModel){
        return ResponseEntity.ok(userService.updateUser(id, userModel));
        }
    @DeleteMapping("users/{id}")
    public  ResponseEntity<userModel> deleteuser (@PathVariable long id){
        return ResponseEntity.ok(userService.deleteById(id));
        }





}
