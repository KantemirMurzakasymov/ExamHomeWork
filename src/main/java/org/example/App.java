package org.example;

import models.Costomer;
import models.Order;
import models.Supplier;
import services.CutomerService;
import services.OrderService;
import services.SupplierService;

public class App {
    public static void main( String[] args ) {

        Supplier supplier = new Supplier();
        SupplierService supplierService = new SupplierService();
        supplierService.save(supplier);

        Costomer costomer = new Costomer();
        CutomerService cutomerService = new CutomerService();
        cutomerService.save(costomer);

        Order order = new Order();
        OrderService orderService = new OrderService();
        orderService.save(order);



    }
}
