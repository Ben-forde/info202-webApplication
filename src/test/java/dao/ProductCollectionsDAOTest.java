/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.math.BigDecimal;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author benforde
 */
public class ProductCollectionsDAOTest {
    
    ProductDAO dao;
    Product p1;
    Product p2;
    Product p3;

    
    
    
    
    @BeforeAll
    public static void initialise() {
        JdbiDaoFactory.setJdbcUri("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
    }      



    @BeforeEach
    public void setUp() {
   
        //dao = new ProductCollectionsDAO();
        dao = JdbiDaoFactory.getProductDAO();
        
        p1 = new Product();
        p1.setProductId("p1");
        p1.setName("p1name");
        p1.setCategory("p1cat");
        p1.setDescription("p1desc");
        p1.setListPrice(new BigDecimal("10.00"));
        p1.setQuantityInStock(new BigDecimal("10.00"));
        
        
        p2 = new Product();
        p2.setProductId("p2");
        p2.setName("p1name");
        p2.setCategory("p2cat");
        p2.setDescription("p1desc");
        p2.setListPrice(new BigDecimal("10.00"));
        p2.setQuantityInStock(new BigDecimal("10.00"));

        p3 = new Product();
        p3.setProductId("p3");
        p3.setName("p3name");
        p3.setCategory("p3cat");
        p3.setDescription("p31desc");
        p3.setListPrice(new BigDecimal("10.00"));
        p3.setQuantityInStock(new BigDecimal("10.00"));  
        
        
        dao.saveProduct(p1);
        dao.saveProduct(p2);
        // intentionally not saving p3
    }
    
    @AfterEach
    public void tearDown() {
        dao.removeProduct(p1);
        dao.removeProduct(p2);
        dao.removeProduct(p3);
    }

    @Test
    public void testSaveProduct() {
        assertThat(dao.getProducts(), not(hasItem(p3)));
        dao.saveProduct(p3);
        assertThat(dao.getProducts(), hasItem(p3));
    }

    @Test
    public void testGetProducts() {
        assertThat(dao.getProducts(), hasItem(p1));
        assertThat(dao.getProducts(), hasItem(p2));
        assertThat(dao.getProducts(), hasSize(2));
    }

    @Test
    public void testRemoveProduct() {
        assertThat(dao.getProducts(), hasItem(p1));
        dao.removeProduct(p1);
        assertThat(dao.getProducts(), not(hasItem(p1)));
    }
    @Test
    public void testGetCatagories(){ 
        assertThat(dao.getCategories(), hasItem("p1cat")); 
            assertThat(dao.getCategories(), hasItem("p2cat")); 
    }
    
    @Test
    public void testSearchById(){
        Product prod = dao.searchById(p1.getProductId());
        assertThat(prod, is(p1));  
        assertThat(prod, not(p2)); 
      
    }
    
    @Test
    public void testFilterByCatagory(){ 
        assertThat(dao.filterByCatagorie("p1cat"), hasItem(p1));
        assertThat(dao.filterByCatagorie("p1cat"), not(hasItem(p2)));
   
    }
}
