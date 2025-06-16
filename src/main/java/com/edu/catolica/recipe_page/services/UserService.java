package com.edu.catolica.recipe_page.services;

import com.edu.catolica.recipe_page.dto.user.UserRequestDTO;
import com.edu.catolica.recipe_page.models.User;
import com.edu.catolica.recipe_page.repositories.UserRepository;
import com.edu.catolica.recipe_page.security.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Boolean findByEmail(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    public User save(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(Encoder.encode(dto.getPassword()));

        return userRepo.save(user);
    }

    public List<User> listUsers() {
        return userRepo.findAll();
    }
}
