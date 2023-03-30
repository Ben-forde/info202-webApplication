/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;

import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;


/**
 *
 * @author benforde
 */
public interface CustomerJdbiDAO extends CustomerDAO {
    
    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO CUSTOMER (USERNAME, FIRSTNAME, SURNAME, PASSWORD, "
            + "EMAILADDRESS, SHIPPINGADDRESS) VALUES(:username, :firstName, "
            + ":surname, :password, :emailAddress, :shippingAddress)" )
    Integer insertCustomer(@BindBean Customer customer);
    
    @Override
    default void saveCustomer(Customer customer){
        Integer customerId = insertCustomer(customer);
        customer.setCustomerId(customerId);
    }
        

    @Override
    @SqlQuery("SELECT * FROM CUSTOMER WHERE USERNAME = :username")
    @RegisterBeanMapper(Customer.class)
    public Customer getCustomer(@Bind("username") String username);
            
                
        
        
    @Override
    @SqlQuery("select exists (select * from customer where customerId = :customerId)")
    @RegisterBeanMapper(Customer.class)
    public Boolean validateCredentials(String username, String password); 
        
    
    
    
}
