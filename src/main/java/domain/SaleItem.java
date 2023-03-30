/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;

/**
 *
 * @author benforde
 */
public class SaleItem {
    private BigDecimal quantityPurchased; 
    private BigDecimal salePrice; 
    private int saleId;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

   

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    

    public BigDecimal getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(BigDecimal quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    
    
    
    public BigDecimal getItemTotal(){
        return quantityPurchased.multiply(salePrice); 
    }
}
