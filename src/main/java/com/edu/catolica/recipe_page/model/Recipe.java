package com.edu.catolica.recipe_page.model;

import com.edu.catolica.recipe_page.enums.RecipeCategory;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

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
