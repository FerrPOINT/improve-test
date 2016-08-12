package com.azhukov.servlet;

import com.azhukov.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alex Zhukov on 11.08.2016.
 */

@WebServlet("/")
public class MainServlet extends HttpServlet {
    
    ProductService productService;
    
    public MainServlet() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        productService = (ProductService) context.getBean("productService");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List products = productService.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("main_page.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String category = req.getParameter("category");
        String name = req.getParameter("name");
        String priceFromParameter = req.getParameter("priceFrom");
        String priceToParameter = req.getParameter("priceTo");
        
        if(category.isEmpty() && name.isEmpty() && priceFromParameter.isEmpty() && priceToParameter.isEmpty()) {
            req.setAttribute("alert", "Нужно ввести хотя бы один параметр");
            req.getRequestDispatcher("main_page.jsp").forward(req, resp);
            return;
        }
        
        double priceFrom;
        if(priceFromParameter.isEmpty()) {
            priceFrom = 0;
        } else {
            priceFrom = Double.parseDouble(priceFromParameter);
        }
        
        double priceTo;
        if(priceToParameter.isEmpty()) {
            priceTo = Double.MAX_VALUE;
        } else {
            priceTo = Double.parseDouble(priceToParameter);
        }
        
        List products = productService.getByCriteria(category, name, priceFrom, priceTo);
        if(products.isEmpty()) {
            req.setAttribute("alert", "Не найдено ни одного продукта с заданными параметрами");
        } else {
            req.setAttribute("products", products);
        }
        req.getRequestDispatcher("main_page.jsp").forward(req, resp);
    }
}
