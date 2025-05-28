package com.edu.catolica.recipe_page.dto.user;

import com.edu.catolica.recipe_page.dto.recipes.RecipeResponseDTO;
import com.edu.catolica.recipe_page.models.User;
import lombok.Data;

import java.util.List;

@Data
public class UserRecipeResponseDTO {
    private String name;
    private String email;
    private List<RecipeResponseDTO> recipes;

    public UserRecipeResponseDTO(User user, List<RecipeResponseDTO> recipes) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.recipes = recipes;
    }

}
