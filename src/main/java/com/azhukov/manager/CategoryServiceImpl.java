package com.azhukov.manager;

import com.azhukov.dao.CategoryDAO;
import com.azhukov.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alex Zhukov on 11.08.2016.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
    
    @Override
    @Transactional
    public void save(Category category) {
        categoryDAO.save(category);
    }
    
    @Override
    @Transactional
    public void update(Category category) {
        categoryDAO.update(category);
    }
    
    @Override
    @Transactional
    public void remove(Category category) {
        categoryDAO.remove(category);
    }
    
    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }
}
