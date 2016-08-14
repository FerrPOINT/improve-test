package com.azhukov.servlet;

import com.azhukov.service.ProductService;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
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
    
    public static final String ENCODING = "UTF-8";
    public static final String SERVLET_PAGE_PATH = "WEB-INF/pages/main_page.jsp";
    public static final String TABLE = "products";
    public static final String ALERT = "alert";
    public static final String CATEGORY = "category";
    public static final String PRODUCT_NAME = "name";
    public static final String PRICE_FROM = "priceFrom";
    public static final String PRICE_TO = "priceTo";
    public static final String NO_PARAMETERS = "Нужно ввести хотя бы один параметр";
    public static final String WRONG_FORMAT = "Неправильный формат ввода";
    public static final String PRODUCTS_NOT_FOUND = "Не найдено ни одного продукта с заданными параметрами";
    
    private ProductService productService;
        
    @Override
    public void init() throws ServletException {
        super.init();
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        productService = (ProductService) ctx.getBean("productService");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        req.setCharacterEncoding(ENCODING);
        List products = productService.getAll();
        req.setAttribute(TABLE, products);
        req.getRequestDispatcher(SERVLET_PAGE_PATH).forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    
        req.setCharacterEncoding(ENCODING);
        RequestDispatcher dispatcher = req.getRequestDispatcher(SERVLET_PAGE_PATH);
        
        String category = req.getParameter(CATEGORY);
        String name = req.getParameter(PRODUCT_NAME);
        String priceFrom = req.getParameter(PRICE_FROM);
        String priceTo = req.getParameter(PRICE_TO);
        
        if(category.isEmpty() && name.isEmpty()
                && priceFrom.isEmpty() && priceTo.isEmpty()) {
            req.setAttribute(ALERT, NO_PARAMETERS);
            dispatcher.forward(req, resp);
            return;
        }
        
        if((!priceFrom.isEmpty() && !NumberUtils.isNumber(priceFrom))
                || (!priceTo.isEmpty() && !NumberUtils.isNumber(priceTo))) {
            req.setAttribute(ALERT, WRONG_FORMAT);
            dispatcher.forward(req, resp);
            return;
        }
        
        List products = productService.getByCriteria(category, name, priceFrom, priceTo);
        
        if(products.isEmpty()) {
            req.setAttribute(ALERT, PRODUCTS_NOT_FOUND);
        } else {
            req.setAttribute(TABLE, products);
        }
    
        dispatcher.forward(req, resp);
    }
}
