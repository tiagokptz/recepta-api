package com.edu.catolica.recipe_page.controllers;

import com.edu.catolica.recipe_page.dto.FilterResponseDTO;
import com.edu.catolica.recipe_page.dto.recipes.RecipeRequestDTO;
import com.edu.catolica.recipe_page.dto.recipes.RecipeResponseDTO;
import com.edu.catolica.recipe_page.dto.UserRecipeResponseDTO;
import com.edu.catolica.recipe_page.exceptions.NotFoundException;
import com.edu.catolica.recipe_page.models.Recipe;
import com.edu.catolica.recipe_page.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<UserRecipeResponseDTO> response = recipeService.listUsersTheirRecipes();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") String recipeId) {
        try {
            recipeService.delete(recipeId);
            return ResponseEntity.ok().build();

        } catch(NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable("id") String recipeId, @RequestBody RecipeRequestDTO recipeRequestDTO) {
        try {
            recipeService.update(recipeId, recipeRequestDTO);
            return ResponseEntity.ok().build();

        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterRecipeByCategory(@RequestParam(required = false) String category) {
        List<FilterResponseDTO> response = recipeService.findByCategories(category);

        return ResponseEntity.ok(response);
    }
}
