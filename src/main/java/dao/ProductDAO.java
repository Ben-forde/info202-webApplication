/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;

/**
 *
 * @author benforde
 */
public interface ProductDAO {

   

    Collection<Product> filterByCatagorie(String s);

    Collection<String> getCategories();

    /**
     *
     * @return
     */
    Collection<Product> getProducts();

    void removeProduct(Product p);

    void saveProduct(Product p);

    Product searchById(String s);
    
}
