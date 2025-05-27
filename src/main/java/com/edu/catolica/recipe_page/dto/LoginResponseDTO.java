package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.models.User;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private String id;
    private String email;
    private String password;

    public LoginResponseDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
