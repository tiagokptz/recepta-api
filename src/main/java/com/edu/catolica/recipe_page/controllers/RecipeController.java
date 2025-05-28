package com.edu.catolica.recipe_page.controllers;

import com.edu.catolica.recipe_page.dto.RecipeRequestDTO;
import com.edu.catolica.recipe_page.dto.RecipeResponseDTO;
import com.edu.catolica.recipe_page.dto.UserRecipeResponseDTO;
import com.edu.catolica.recipe_page.exceptions.NotFoundException;
import com.edu.catolica.recipe_page.models.Recipe;
import com.edu.catolica.recipe_page.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public ResponseEntity<?> registerRecipe(@RequestBody RecipeRequestDTO recipeRequestDTO) {
        Recipe recipe = recipeService.save(recipeRequestDTO);

        return ResponseEntity.ok(new RecipeResponseDTO(recipe));
    }

    @GetMapping
    public ResponseEntity<?> listUserWithTheirRecipes() {
        List<UserRecipeResponseDTO> response = recipeService.listUserTheirRecipes();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") String recipeId) {
        try {
            recipeService.delete(recipeId);
            return ResponseEntity.ok().build();

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
