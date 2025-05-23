package com.edu.catolica.recipe_page.repositories;

import com.edu.catolica.recipe_page.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
