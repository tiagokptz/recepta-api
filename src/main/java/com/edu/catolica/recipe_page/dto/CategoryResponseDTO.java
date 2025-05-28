package com.edu.catolica.recipe_page.dto;

import com.edu.catolica.recipe_page.models.Category;
import lombok.Data;

@Data
public class CategoryResponseDTO {
    private String id;
    private String name;

    public CategoryResponseDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
