package com.azhukov.service;

import com.azhukov.entities.Category;

import java.util.List;

/**
 * Created by Alex Zhukov on 11.08.2016.
 */
public interface CategoryService {
    
    void save(Category category);
    
    void update(Category category);
    
    void remove(Category category);
    
    List<Category> getAll();
}
