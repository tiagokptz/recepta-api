package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.dto.recipes.RecipeResponseDTO;
import com.edu.catolica.recipe_page.models.User;
import lombok.Data;

import java.util.List;

@Data
public class UserRecipeResponseDTO {
    private String name;
    private String email;
    private RecipeResponseDTO recipe;

    public UserRecipeResponseDTO(User user, RecipeResponseDTO recipe) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.recipe = recipe;
    }

}
