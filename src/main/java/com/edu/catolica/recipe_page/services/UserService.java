package com.edu.catolica.recipe_page.services;

import com.edu.catolica.recipe_page.dto.UserRequestDTO;
import com.edu.catolica.recipe_page.model.User;
import com.edu.catolica.recipe_page.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Boolean findByEmail(String email) {
        if(userRepo.findByEmail(email).isEmpty()) {
            return false;
        }

        return true;
    }

    public User saveUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        return userRepo.save(user);
    }
}
