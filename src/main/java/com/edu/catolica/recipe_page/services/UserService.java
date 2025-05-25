package com.edu.catolica.recipe_page.services;

import com.edu.catolica.recipe_page.dto.LoginRequestDTO;
import com.edu.catolica.recipe_page.dto.LoginResponseDTO;
import com.edu.catolica.recipe_page.dto.UserRequestDTO;
import com.edu.catolica.recipe_page.exceptions.CredentialsInvalidException;
import com.edu.catolica.recipe_page.model.User;
import com.edu.catolica.recipe_page.repositories.UserRepository;
import com.edu.catolica.recipe_page.security.Encoder;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    //posso lançar um erro aqui
    public Boolean findByEmail(String email) {
        if(userRepo.findByEmail(email).isEmpty()) {
            return false;
        }

        return true;
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
