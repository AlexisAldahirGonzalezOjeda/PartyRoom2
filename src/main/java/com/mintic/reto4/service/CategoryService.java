/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.service;

import com.mintic.reto4.model.Category;
import com.mintic.reto4.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c) {
        if (c.getId() == null) {
            return categoryRepository.save(c);
        } else {
            Optional<Category> e = categoryRepository.getCategory(c.getId());
            if (e.isPresent()) {
                return c;
            } else {
                return categoryRepository.save(c);
            }
        }
    }

    public Category update(Category c) {
        if (c.getId() != null) {
            Optional<Category> c2 = categoryRepository.getCategory(c.getId());
            if (c2.isPresent()) {
                if (c.getName() != null) {
                    c2.get().setName(c.getName());
                }
                if (c.getDescription() != null) {
                    c2.get().setDescription(c.getDescription());
                }
                categoryRepository.save(c2.get());
                return c2.get();
            } else {
                return c;
            }
        } else {
            return c;
        }
    }

    public void delete(int id) { 
        Optional<Category> c = categoryRepository.getCategory(id);
        if (c.isPresent()) {
            categoryRepository.delete(c.get()); 
        } 
    }

}
