/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.SaleDao;
import domain.Sale;
import domain.SaleItem;
import java.time.LocalDateTime;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;

/**
 *
 * @author benforde
 */

    public interface SaleJdbiDAO extends SaleDao {

    @SqlUpdate("INSERT INTO SALE (SALEID, LOCALDATETIME, STATUS, CUSTOMERID)"
            + "VALUES(:saleId, :date, :status, :customer.customerId)") 
    @GetGeneratedKeys
    Integer insertSale(@BindBean Sale sale);

    @SqlUpdate("INSERT INTO SALE_ITEM (SALEID, PRODUCTID, quantityPurchased, Sale_Price) "
            + "VALUES(:saleId, :product.productId, :quantityPurchased, :salePrice)")
    void insertSaleItem(@BindBean SaleItem item, @Bind("saleId") Integer saleId);
    
    @SqlUpdate("update product set quantity_In_Stock = quantity_In_Stock - :quantityPurchased where"
            + " PRODUCT_ID = :product.productId")
    void updateStockLevel(@BindBean SaleItem item);

    @Override
    @Transaction
    default void save(Sale sale) {
        // save current date
        sale.setDate(LocalDateTime.now());

        // set sale status
        sale.setStatus("NEW ORDER");

        // call the insertSale method, and get the generated sale ID.
        Integer saleId = insertSale(sale);
        sale.setSaleId(saleId);

        // loop through the sale's items.
        for (SaleItem item : sale.getItems()) {
            insertSaleItem(item, saleId);
            updateStockLevel(item);
        }

    }
}

