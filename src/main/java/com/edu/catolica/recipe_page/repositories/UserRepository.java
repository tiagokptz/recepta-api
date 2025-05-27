package com.edu.catolica.recipe_page.repositories;

import com.edu.catolica.recipe_page.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
