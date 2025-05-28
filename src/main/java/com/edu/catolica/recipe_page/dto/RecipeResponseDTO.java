package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.enums.RecipeCategory;
import com.edu.catolica.recipe_page.models.Recipe;
import lombok.Data;

import java.util.List;

@Data
public class RecipeResponseDTO {
    private String recipeName;
    private String ingredients;
    private String preparationMethod;
    private String authorId;
    private Integer preparationTime;
    private List<RecipeCategory> categories;

    public RecipeResponseDTO(Recipe recipe) {
        this.recipeName = recipe.getRecipeName();
        this.ingredients = recipe.getIngredients();
        this.preparationMethod = recipe.getPreparationMethod();
        this.authorId = recipe.getAuthorId();
        this.preparationTime = recipe.getPreparationTime();
        this.categories = recipe.getCategories();
    }
}
