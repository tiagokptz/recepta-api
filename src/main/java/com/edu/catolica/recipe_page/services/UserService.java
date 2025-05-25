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

import java.util.Optional;

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

    public User login(LoginRequestDTO loginRequestDTO) throws CredentialsInvalidException {
        User user = userRepo.findByEmail(loginRequestDTO.getEmail()).orElseThrow(() -> new CredentialsInvalidException("Invalid Credentials"));

        String encodePassword = Encoder.encode(loginRequestDTO.getPassword());

        if(!(user.getPassword().equals(encodePassword))) {
            throw new CredentialsInvalidException("Invalid credentials!");
        }

        return user;
    }

    public User save(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(Encoder.encode(userRequestDTO.getPassword()));

        return userRepo.save(user);
    }
}
