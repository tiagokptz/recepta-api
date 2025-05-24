package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.model.User;
import lombok.Data;

@Data
public class UserResponseDTO {
    private String id;
    private String name;
    private String email;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
