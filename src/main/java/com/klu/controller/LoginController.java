package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.klu.repository.UserRepository;
import com.klu.entity.*;

//LoginController.java
@Controller
public class LoginController {
 @Autowired
 private UserRepository userRepository;

 @GetMapping("/login")
 public String loginPage() {
     return "login";
 }

 @PostMapping("/login")
 public ResponseEntity<String> loginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
     User user = userRepository.findByUsername(username);
     if (user != null && user.getPassword().equals(password)) {
         // Successful login
         return ResponseEntity.ok("Success");
     } 
  else {
     // Failed login
     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed");
 }
 }
}

