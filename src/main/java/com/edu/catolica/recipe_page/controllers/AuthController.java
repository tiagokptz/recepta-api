package com.edu.catolica.recipe_page.controllers;

import com.edu.catolica.recipe_page.dto.LoginRequestDTO;
import com.edu.catolica.recipe_page.dto.LoginResponseDTO;
import com.edu.catolica.recipe_page.dto.UserRequestDTO;
import com.edu.catolica.recipe_page.dto.UserResponseDTO;
import com.edu.catolica.recipe_page.exceptions.CredentialsInvalidException;
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

        User user = userService.save(userRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponseDTO(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            User user = userService.login(loginRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new LoginResponseDTO(user));

        } catch(CredentialsInvalidException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
