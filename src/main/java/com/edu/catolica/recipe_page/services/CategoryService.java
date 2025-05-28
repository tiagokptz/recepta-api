package com.edu.catolica.recipe_page.services;

import com.edu.catolica.recipe_page.models.Category;
import com.edu.catolica.recipe_page.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> listAll() {
        return categoryRepo.findAll();
    }
}
