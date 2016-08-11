package com.azhukov.dao;

import com.azhukov.entities.Category;
import com.azhukov.entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Alex Zhukov on 10.08.2016.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }
    
    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }
    
    @Override
    public void remove(Product product) {
        entityManager.remove(product);
    }
    
    @Override
    public List<Product> getByCriteria(Category category, String name, double priceFrom, double priceTo) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> productCriteria = cb.createQuery(Product.class);
        Root<Product> productRoot = productCriteria.from(Product.class);
        productCriteria.select(productRoot);
        
        Expression<Double> price = productRoot.get("price");
        productCriteria.where(
            cb.like(cb.lower(productRoot.get("category").get("name").as(String.class)),
                    category.getName().toLowerCase()+"%"),
            cb.like(cb.lower(productRoot.get("name").as(String.class)),name.toLowerCase()+"%"),
            cb.lt(price, priceTo),
            cb.gt(price, priceFrom));
        
        return entityManager.createQuery(productCriteria).getResultList();
    }
    
    @Override
    public List<Product> getAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }
}
