/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author benforde
 */
public class Sale {
    private Integer saleId; 
    private LocalDateTime date; 
    private String status; 
    private Customer customer;
    

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime localDateTime) {
        this.date = localDateTime;
    }
    

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    
    private Collection<SaleItem> items = new HashSet();
    
    
    public BigDecimal getTotal(){
        BigDecimal tot = BigDecimal.ZERO;
        for (SaleItem item : items) {
            tot = tot.add(item.getItemTotal());
        }
        
        return tot;
    }
    
    public void addItem(SaleItem saleItem){
      items.add(saleItem);
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString() {
        return "Sale{" + "saleId=" + saleId + ", date=" + date + ", status=" + status + ", customer=" + customer + ", items=" + items + '}';
    }

    public void setStatus(String new_order) {
        this.status = new_order; 
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getSaleId() {
        return saleId;
    }

    
    public Iterable<SaleItem> getItems() {
        return items;
    }
    
}
