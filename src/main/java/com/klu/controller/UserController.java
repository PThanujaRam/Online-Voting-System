package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.User;
import com.klu.repository.UserRepository;

import org.springframework.dao.DataIntegrityViolationException; // Import this exception

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            // Check if the adharNumber already exists in the database
            User existingUser = userRepository.findByAdharNumber(user.getAdharNumber());
            if (existingUser != null) {
                return new ResponseEntity<>("Adhar Number is already in use.", HttpStatus.BAD_REQUEST);
            }

            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            // Handle unique constraint violation (duplicate adharNumber)
            return new ResponseEntity<>("Adhar Number is already in use.", HttpStatus.BAD_REQUEST);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error adding user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   





}
