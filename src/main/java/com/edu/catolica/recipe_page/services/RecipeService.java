package com.edu.catolica.recipe_page.services;

import com.edu.catolica.recipe_page.dto.recipes.RecipeRequestDTO;
import com.edu.catolica.recipe_page.dto.recipes.RecipeResponseDTO;
import com.edu.catolica.recipe_page.dto.user.UserRecipeResponseDTO;
import com.edu.catolica.recipe_page.exceptions.NotFoundException;
import com.edu.catolica.recipe_page.models.Recipe;
import com.edu.catolica.recipe_page.repositories.RecipeRepository;
import com.edu.catolica.recipe_page.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepo;

    @Autowired
    private UserRepository userRepo;

    public Recipe save(RecipeRequestDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(dto.getRecipeName());
        recipe.setIngredients(dto.getIngredients());
        recipe.setPreparationMethod(dto.getPreparationMethod());
        recipe.setPreparationTime(dto.getPreparationTime());
        recipe.setAuthorId(dto.getAuthorId());
        recipe.setCategories(dto.getCategories());

        return recipeRepo.save(recipe);
    }

    public List<UserRecipeResponseDTO> listUserTheirRecipes() {
        return userRepo.findAll().stream().map(user -> {
            List<RecipeResponseDTO> recipes = recipeRepo.findByAuthorId(user.getId())
                    .stream()
                    .map(RecipeResponseDTO::new)
                    .collect(Collectors.toList());

            return new UserRecipeResponseDTO(user, recipes);
        }).collect(Collectors.toList());
    }

    public void delete(String id) throws NotFoundException {
        Recipe recipe = recipeRepo.findById(id).orElseThrow(() -> new NotFoundException("Recipe not found!"));

        recipeRepo.delete(recipe);
    }

    public void update(String id, RecipeRequestDTO dto) throws Exception {
        if(id == null) {
            throw new NullPointerException("Id cannot be null!");
        }

        Recipe recipe = recipeRepo.findById(id).orElseThrow(() -> new NotFoundException("Recipe not found!"));

        recipe.setRecipeName(dto.getRecipeName());
        recipe.setIngredients(dto.getIngredients());
        recipe.setPreparationMethod(dto.getPreparationMethod());
        recipe.setPreparationTime(dto.getPreparationTime());
        recipe.setAuthorId(dto.getAuthorId());
        recipe.setCategories(dto.getCategories());

        recipeRepo.save(recipe);
    }
}
