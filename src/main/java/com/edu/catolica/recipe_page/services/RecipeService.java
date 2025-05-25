package com.edu.catolica.recipe_page.services;

import com.edu.catolica.recipe_page.dto.RecipeRequestDTO;
import com.edu.catolica.recipe_page.model.Recipe;
import com.edu.catolica.recipe_page.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepo;

    public Recipe save(RecipeRequestDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(dto.getRecipeName());
        recipe.setIngredients(dto.getIngredients());
        recipe.setPreparationMethod(dto.getPreparationMethod());
        recipe.setAuthorId(dto.getAuthorId());
        recipe.setCategories(dto.getCategories());

        return recipeRepo.save(recipe);
    }
}
