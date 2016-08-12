package com.azhukov.dao;


import com.azhukov.entities.Category;
import com.azhukov.entities.Product;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Alex Zhukov on 10.08.2016.
 */
public interface ProductDAO {
    
    void save(Product product);
    
    void update(Product product);
    
    void remove(Product product);
    
    List<Product> getByCriteria(String categoryName, String name,
                                double priceFrom, double priceTo);
    
    List<Product> getAll();
    
}