/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.SaleDao;
import domain.Sale;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author benforde
 */
public class SaleModule extends Jooby {

    public SaleModule(SaleDao saleDao) {
        post("/api/sales", ctx -> {
            Sale sale = ctx.body().to(Sale.class);
            saleDao.save(sale);
            System.out.println(sale);
            return ctx.send(StatusCode.CREATED);
        });
    }
}
