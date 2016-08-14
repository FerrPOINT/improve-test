package com.azhukov.service;

import com.azhukov.dao.ProductDAO;
import com.azhukov.entities.Category;
import com.azhukov.entities.Product;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alex Zhukov on 10.08.2016.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    
    
    @Override
    @Transactional
    public void save(Product product) {
        productDAO.save(product);
    }
    
    @Override
    @Transactional
    public void update(Product product) {
        productDAO.update(product);
    }
    
    @Override
    @Transactional
    public void remove(Product product) {
        productDAO.remove(product);
    }
    
    @Override
    public List<Product> getByCriteria(String categoryName, String name,
                                       String priceFrom, String priceTo) {
    
        double priceFromValue;
        if(priceFrom.isEmpty()) {
            priceFromValue = 0;
        } else {
            priceFromValue = Double.parseDouble(priceFrom);
        }
    
        double priceToValue;
        if(priceTo.isEmpty()) {
            priceToValue = Double.MAX_VALUE;
        } else {
            priceToValue = Double.parseDouble(priceTo);
        }
        
        return productDAO.getByCriteria(categoryName, name, priceFromValue, priceToValue);
    }
    
    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }
}
