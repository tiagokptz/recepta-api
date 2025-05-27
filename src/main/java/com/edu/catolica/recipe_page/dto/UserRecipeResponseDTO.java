package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.models.Recipe;
import com.edu.catolica.recipe_page.models.User;
import lombok.Data;

import java.util.List;

@Data
public class UserRecipeResponseDTO {
    private String id;
    private String name;
    private String email;
    private List<RecipeResponseDTO> recipes;

    public UserRecipeResponseDTO(User user, List<RecipeResponseDTO> recipes) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.recipes = recipes;
    }

}
