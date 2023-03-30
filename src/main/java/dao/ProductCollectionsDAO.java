/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import domain.Product;
import java.util.ArrayList; 
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;



/**
 *
 * @author benforde
 */
public class ProductCollectionsDAO implements ProductDAO {
    
    private static Collection<Product> products = new HashSet<>();
    private static Collection<String> categories = new HashSet<>();
    private static Map<String, Product> productMap = new HashMap<>();
    private static final Multimap<String, Product> map = ArrayListMultimap.create();
   

    
    
    @Override
    public void saveProduct(Product p){ 
        products.add(p); 
        categories.add(p.getCategory()); 
        productMap.put(p.getProductId(), p); 
        map.put(p.getCategory(), p); 
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public Collection<Product> getProducts() {
    return products;
    }   
    @Override
    public Collection<String> getCategories(){
        return categories; 
    }
    
    @Override
    public void removeProduct(Product p) {
        products.remove(p);
        productMap.remove(p.getProductId());
        map.remove(p.getCategory(), p);
        
    }
    
   
   
    @Override
   public Product searchById(String s){
        Product getId = productMap.get(s);
        return getId; 
       }
   
    @Override
   public Collection<Product> filterByCatagorie(String s) {
       return map.get(s); 
   }
   }


