package com.edu.catolica.recipe_page.controllers;

import com.edu.catolica.recipe_page.dto.user.UserResponseDTO;
import com.edu.catolica.recipe_page.models.User;
import com.edu.catolica.recipe_page.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> listUsers() {
        List<User> users = userService.listUsers();
        List<UserResponseDTO> response = users.stream()
                .map(UserResponseDTO :: new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
