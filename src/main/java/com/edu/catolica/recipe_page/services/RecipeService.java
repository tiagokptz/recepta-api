package com.edu.catolica.recipe_page.services;

import com.edu.catolica.recipe_page.dto.FilterResponseDTO;
import com.edu.catolica.recipe_page.dto.recipes.RecipeRequestDTO;
import com.edu.catolica.recipe_page.dto.recipes.RecipeResponseDTO;
import com.edu.catolica.recipe_page.dto.UserRecipeResponseDTO;
import com.edu.catolica.recipe_page.exceptions.NotFoundException;
import com.edu.catolica.recipe_page.models.Recipe;
import com.edu.catolica.recipe_page.models.User;
import com.edu.catolica.recipe_page.repositories.RecipeRepository;
import com.edu.catolica.recipe_page.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Filter;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepo;

    @Autowired
    private UserRepository userRepo;

    //posso retornar somente RecipeResponseDTO
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

    public List<UserRecipeResponseDTO> listUsersTheirRecipes() {
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

    public List<RecipeResponseDTO> listRecipesByUserId(String id) {
        return recipeRepo.findByAuthorId(id)
                .stream()
                .map(RecipeResponseDTO :: new)
                    .collect(Collectors.toList());
    }

    public List<FilterResponseDTO> findByCategories(String category) {
        return recipeRepo.findByCategories(category)
                .stream()
                .map(recipe -> {
                    return userRepo.findById(recipe.getAuthorId())
                            .map(user -> new FilterResponseDTO(user, recipe)).orElse(null);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        /*return recipeRepo.findByCategories(categories)
                .stream()
                .map(recipe -> {
                    return userRepo.findById(recipe.getAuthorId())
                            .map(user -> new FilterResponseDTO(user, recipe)).orElse(null);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());*/
    }
}
