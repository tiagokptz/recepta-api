package com.edu.catolica.recipe_page;

import com.edu.catolica.recipe_page.models.User;
import com.edu.catolica.recipe_page.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepo;

    @Test
    void saveUserTest() {
        User user = new User();
        user.setId(new ObjectId().toHexString());
        user.setName("gugu");
        user.setEmail("gustavo@gmail.com");
        user.setPassword("lule123");

        userRepo.save(user);
        System.out.println("user saved");
    }
}
