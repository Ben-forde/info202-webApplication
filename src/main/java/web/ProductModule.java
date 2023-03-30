/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.JdbiDaoFactory;
import dao.ProductDAO;
import io.jooby.Jooby;

/**
 *
 * @author benforde
 */
public class ProductModule extends Jooby {

    public ProductModule(ProductDAO productDao) {
        get("/api/products", ctx -> productDao.getProducts());
        get("/api/products/{id}", ctx -> {
            String id = ctx.path("id").value();
            return productDao.searchById(id);
        });
        get("/api/categories", ctx -> productDao.getCategories());
        get("/api/categories/{category}", ctx -> {
            String category = ctx.path("category").value();
            return productDao.filterByCatagorie(category); 
                });
       
    }

}
