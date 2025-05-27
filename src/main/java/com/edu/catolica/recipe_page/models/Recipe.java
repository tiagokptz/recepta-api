package com.edu.catolica.recipe_page.models;

import com.edu.catolica.recipe_page.enums.RecipeCategory;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "recipes")
public class Recipe {

    @Id
    private String id;
    private String recipeName;
    private String ingredients;
    private String preparationMethod;
    private String authorId;
    private List<RecipeCategory> categories;
}
