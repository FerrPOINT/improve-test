package com.azhukov.dao;

import com.azhukov.entities.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Alex Zhukov on 11.08.2016.
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void save(Category category) {
        entityManager.persist(category);
    }
    
    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }
    
    @Override
    public void remove(Category category) {
        entityManager.remove(category);
    }
    
    @Override
    public List<Category> getAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }
}
