package com.edu.catolica.recipe_page.controllers;

import com.edu.catolica.recipe_page.dto.RecipeRequestDTO;
import com.edu.catolica.recipe_page.dto.RecipeResponseDTO;
import com.edu.catolica.recipe_page.model.Recipe;
import com.edu.catolica.recipe_page.model.User;
import com.edu.catolica.recipe_page.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
