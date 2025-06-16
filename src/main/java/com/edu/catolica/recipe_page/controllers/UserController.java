package com.edu.catolica.recipe_page.controllers;

import com.edu.catolica.recipe_page.dto.recipes.RecipeResponseDTO;
import com.edu.catolica.recipe_page.dto.user.UserResponseDTO;
import com.edu.catolica.recipe_page.services.RecipeService;
import com.edu.catolica.recipe_page.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping()
    public ResponseEntity<?> listUsers() {
        List<UserResponseDTO> response = userService.listUsers()
                .stream()
                .map(UserResponseDTO :: new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/recipes")
    public ResponseEntity<?> listRecipesByUserId(@PathVariable("id") String userId) {
        List<RecipeResponseDTO> response = recipeService.listRecipesByUserId(userId);

        return ResponseEntity.ok(response);
    }
}
