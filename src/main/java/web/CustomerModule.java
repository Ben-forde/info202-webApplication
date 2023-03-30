/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CustomerDAO;
import domain.Customer;
import io.jooby.Jooby;
import io.jooby.StatusCode;


/**
 *
 * @author benforde
 */
public class CustomerModule extends Jooby {

    public CustomerModule(CustomerDAO customerDao) {
        get("/api/customers/{username}", ctx -> {
            String username = ctx.path("username").value();
            return customerDao.getCustomer(username);
        });
        
        post("/api/register", ctx -> {
            Customer customer = ctx.body().to(Customer.class);
            customerDao.saveCustomer(customer);
            return ctx.send(StatusCode.CREATED);
        });
        
           
    }
    
}
