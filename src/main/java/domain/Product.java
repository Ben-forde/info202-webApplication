/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.util.Objects;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author benforde
 */
public class Product {
    @NotNull(message = "Name must be provided.")
    @NotBlank(message = "Name must be provided.")
    @Length(min=2, message="Name must contain at least two characters.")
    private String name;
    @NotNull(message = "Product Id must be provied.")
    @NotBlank(message = "Product Id must be provied.")
    @Length(min=6, message= "Product Id must be at leat six characters long.")
    private String productId;
    
    private String description;
    @NotNull(message = "Must provide a category.")
    private String category; 
    @NotNull(message = "Price must be provided.")
    @NotNegative(message = "Price must be zero or greater.")
    private BigDecimal listPrice;    
    @NotNull(message = "must provide a quantity.")
    @NotNegative(message = "quantitiy must be a zero or greater, not a negative.")
    private BigDecimal quantityInStock; 

    @Override
    public String toString() {
        return productId + " " + name; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    //getters for the data fields
    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public String getProductId() {
        return productId;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.productId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productId, other.productId)) {
            return false;
        }
        return true;
    }
     
    
    //setters for the data feilds

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    
    
    


   
    
}
