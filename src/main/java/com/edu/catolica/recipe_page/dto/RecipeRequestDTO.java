package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.models.Category;
import lombok.Data;

import java.util.List;

@Data
public class RecipeRequestDTO {
    private String recipeName;
    private String ingredients;
    private String preparationMethod;
    private String authorId;
    private Integer preparationTime;
    private List<String> categories;
}
