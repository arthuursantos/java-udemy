package com.javaudemy.project.services;

import com.javaudemy.project.entities.Category;
import com.javaudemy.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> findAll() {
        return CategoryRepository.findAll();
    }

    public Category findById(int id) {
        Optional<Category> obj = CategoryRepository.findById(id);
        return obj.get();
    }

}
