package com.edu.catolica.recipe_page.repositories;

import com.edu.catolica.recipe_page.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
