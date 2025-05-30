package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.models.Recipe;
import com.edu.catolica.recipe_page.models.User;
import lombok.Data;

import java.util.List;

@Data
public class FilterResponseDTO {
    private String author;
    private String email;
    private String recipeId;
    private String recipeName;
    private String ingredients;
    private String preparationMethod;
    private String authorId;
    private String preparationTime;
    private List<String> categories;

    public FilterResponseDTO(User user, Recipe recipe) {
        this.author = user.getName();
        this.email = user.getEmail();
        this.recipeId = recipe.getId();
        this.recipeName = recipe.getRecipeName();
        this.ingredients = recipe.getIngredients();
        this.preparationMethod = recipe.getPreparationMethod();
        this.authorId = recipe.getAuthorId();
        this.preparationTime = recipe.getPreparationTime();
        this.categories = recipe.getCategories();
    }
}
