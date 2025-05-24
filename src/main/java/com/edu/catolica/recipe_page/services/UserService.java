package com.edu.catolica.recipe_page.services;

import com.edu.catolica.recipe_page.dto.LoginRequestDTO;
import com.edu.catolica.recipe_page.dto.LoginResponseDTO;
import com.edu.catolica.recipe_page.dto.UserRequestDTO;
import com.edu.catolica.recipe_page.exceptions.CredentialsInvalidException;
import com.edu.catolica.recipe_page.model.User;
import com.edu.catolica.recipe_page.repositories.UserRepository;
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
        Optional<User> userOptional = userRepo.findByEmail(loginRequestDTO.getEmail());

        if(userOptional.isEmpty()) {
           throw new CredentialsInvalidException("Email invalid!");
        }

        User user = userOptional.get();
        if(!(user.getPassword().equals(loginRequestDTO.getPassword()))) {
            throw new CredentialsInvalidException("Password invalid!");
        }

        return user;
    }

    public User save(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        return userRepo.save(user);
    }
}
