package com.example.java57.services;

import com.example.java57.model.User;
import com.example.java57.repositoires.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
