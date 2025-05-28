package com.edu.catolica.recipe_page.repositories;

import com.edu.catolica.recipe_page.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
