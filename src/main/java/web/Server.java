/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import dao.SaleDao;
import dao.CustomerDAO;
import dao.JdbiDaoFactory;
import dao.ProductDAO;
import io.jooby.Jooby;

import io.jooby.json.JacksonModule;

/**
 *
 * @author benforde
 */
public class Server extends Jooby {

    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");
        new Server().start();
    }
    private ProductDAO productDao = JdbiDaoFactory.getProductDAO();
 //   private CustomerDAO customerDao = new CustomerCollectionsDAO();
    private CustomerDAO customerDao = JdbiDaoFactory.getCustomerDAO();
    SaleDao saleDao = JdbiDaoFactory.getSaleJdbiDao();
    public Server() {
        install(new JacksonModule());
        mount(new ProductModule(productDao));
        mount(new CustomerModule(customerDao));
        mount(new StaticAssetModule());
        mount(new SaleModule(saleDao));
        
    }
}