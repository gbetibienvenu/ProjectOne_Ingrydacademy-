package com.example.LibraryBook.repository;

//import com.example.LibraryBook.controller.User;
import com.example.LibraryBook.model.UserModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findUserByEmailIgnoreCase(String email);


    List<UserModel> findByFullName(String fullname);


    List<UserModel> findByAge(Integer age);


    List<UserModel> findByAddress(String address);
}
