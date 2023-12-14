package com.example.LibraryBook.service;

import com.example.LibraryBook.model.UserModel;
import com.example.LibraryBook.repository.UserRepository;
import jakarta.persistence.Cacheable;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Cacheable("getAllUsers")
//    public List<UserModel> getAllUsers(){
//        return userRepository.findAll();
//    }
    @CacheEvict (value = {"getAllUsers", "getBookById"}, allEntries = true)
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
    @CacheEvict (value = {"getAllUsers", "getBookById"}, allEntries = true)
    public void updateUser(UserModel usermodel){
         userRepository.save(usermodel);
    }
    public UserModel findUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
    public UserModel findByEmail(String email){
        return userRepository.findUserByEmailIgnoreCase(email);
    }
//    public UserModel findUserByFullname(String fullname){
//        return userRepository.findByFullName(fullname);
//
//    }

}

//    @CacheEvict(value = "allUsers", allEntries = true)
//    public UserModel saveUser(UserModel userModel){
//
//        return userRepository.save(userModel);
//    }

//    public Map<String, Boolean> SaveAllUser(List<UserModel> Users){
//        Map<String, Boolean> response = new HashMap<>();
//        for(UserModel user : users ){
//            response.put(user.getFullName() + "user added successfully", true);
//        }
//    }
//    @Cacheable ("allUsers")
//    public List<UserModel> findAllUsers(){
//        return userRepository.findAll();
////    }
//    @Cacheable(value = "singleUsers", key = "#id")
//    public UserModel getUserById(Long id){
//        return userRepository.findById(id).orElse(null);
//    }
//
//   @CacheEvict(value = {"singleUsers", "allUsers"}, key = "#id")
//   public String updateUser(Long id, UserModel advanceUser){
//       UserModel toUpdate = userRepository.findById(id).orElseThrow(() ->
//


