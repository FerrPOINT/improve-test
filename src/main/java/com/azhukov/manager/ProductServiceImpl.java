package com.azhukov.manager;

import com.azhukov.dao.ProductDAO;
import com.azhukov.entities.Category;
import com.azhukov.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public List<Product> getByCriteria(Category category, String name, double priceFrom, double priceTo) {
        return productDAO.getByCriteria(category, name, priceFrom, priceTo);
    }
    
    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }
}
