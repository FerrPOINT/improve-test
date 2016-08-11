package com.azhukov.dao;

import com.azhukov.entities.Category;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Alex Zhukov on 11.08.2016.
 */
public interface CategoryDAO {
    
    void save(Category category);
    
    void update(Category category);
    
    void remove(Category category);
    
    List<Category> getAll();
    
}
