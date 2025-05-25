package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.enums.RecipeCategory;
import lombok.Data;

import java.util.List;

@Data
public class RecipeRequestDTO {
    private String recipeName;
    private String ingredients;
    private String preparationMethod;
    private String authorId;
    private List<RecipeCategory> categories;
}
