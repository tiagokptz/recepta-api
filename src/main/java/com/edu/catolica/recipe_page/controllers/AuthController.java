package com.edu.catolica.recipe_page.controllers;

import com.edu.catolica.recipe_page.dto.UserRequestDTO;
import com.edu.catolica.recipe_page.dto.UserResponseDTO;
import com.edu.catolica.recipe_page.model.User;
import com.edu.catolica.recipe_page.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        if(userService.findByEmail(userRequestDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered!");
        }

        User user = userService.saveUser(userRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponseDTO(user));
    }
}
