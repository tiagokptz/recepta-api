package com.edu.catolica.recipe_page.dto.login;

import com.edu.catolica.recipe_page.models.User;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private String id;
    private String name;
    private String email;

    public LoginResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
