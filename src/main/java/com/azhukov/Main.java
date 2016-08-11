package com.azhukov;

import com.azhukov.entities.Category;
import com.azhukov.entities.Product;
import com.azhukov.manager.CategoryService;
import com.azhukov.manager.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alex Zhukov on 10.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("running");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CategoryService categoryService = (CategoryService) context.getBean("categoryService");
        ProductService productService = (ProductService) context.getBean("productService");
        
        // Category[] categories = new Category[]{new Category("food"), new Category("sport"), new Category("recreation"), new Category("electronic"), new Category("transport"), new Category("toy"), new Category("music"), new Category("weapon")};
        //
        //        for(Category category : categories) {
        //            categoryService.save(category);
        //        }
        //
        //        String[] randomWords = new String[]{"Super", "Weak", "Broken", "Best", "Hyper", "Crooked", "Lazy"};
        //
        //        Random rnd = new Random();
        //        double startPrice = 0.99;
        //        List<Product> products = new ArrayList();
        //        for(int i = 0; i < 50; i++) {
        //            Category c = categories[rnd.nextInt(categories.length)];
        //            String name = randomWords[rnd.nextInt(randomWords.length)]+" "+c.getName();
        //            double price = startPrice + rnd.nextInt(1000);
        //            products.add(new Product(c,name,price));
        //        }
        //        for(Product product : products) {
        //            productService.save(product);
        //        }
        
        
        List<Product> prods = productService.getByCriteria(new Category(""), "w", 0, 270);
        for(Product prod : prods) {
            System.out.println(prod.getCategory().getName() + "  " + prod.getName() + "  " + prod.getPrice());
        }
    }
}
