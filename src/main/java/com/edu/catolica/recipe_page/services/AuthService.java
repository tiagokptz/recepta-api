package com.edu.catolica.recipe_page.services;

import com.edu.catolica.recipe_page.dto.LoginRequestDTO;
import com.edu.catolica.recipe_page.exceptions.CredentialsInvalidException;
import com.edu.catolica.recipe_page.models.User;
import com.edu.catolica.recipe_page.repositories.UserRepository;
import com.edu.catolica.recipe_page.security.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    public User login(LoginRequestDTO loginRequestDTO) throws CredentialsInvalidException {
        User user = userRepo.findByEmail(loginRequestDTO.getEmail()).orElseThrow(() -> new CredentialsInvalidException("Invalid Credentials"));

        String encodePassword = Encoder.encode(loginRequestDTO.getPassword());

        if(!(user.getPassword().equals(encodePassword))) {
            throw new CredentialsInvalidException("Invalid credentials!");
        }

        return user;
    }
}
