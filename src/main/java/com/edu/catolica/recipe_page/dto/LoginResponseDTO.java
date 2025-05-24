package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.model.User;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private String email;
    private String password;

    public LoginResponseDTO(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
