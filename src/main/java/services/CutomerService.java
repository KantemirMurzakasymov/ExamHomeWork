package services;

import Enums.OrderStatus;
import configuration.ConfigDB;
import models.Costomer;
import models.Order;
import models.Supplier;
import org.hibernate.Session;

import java.util.List;

public class CutomerService {

    public void save(Costomer newCustomer) {
        Session session = ConfigDB.createSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(newCustomer);
        session.getTransaction().commit();
        session.close();
        System.out.println(" ADDED SUCCESSFULLY " + newCustomer);

        // save a newCustomer to database
    }

    public void makeAnOrder(Long customerId, Order newOrder) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        session.update(String.valueOf(customerId),newOrder);
        session.getTransaction().commit();
        session.close();

        // find customer and give order to customer
    }

    public void cancelOrder(Long customerId, Long orderId) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        //session.find(Costomer.class,Order.class).getId();
        session.update(String.valueOf(customerId),orderId);
        session.cancelQuery();
        session.getTransaction().commit();
        session.close();

        // find customer with :customerId and find customer's order with id = :orderId
        // and setOrder status CANCELED
    }

    public void update(Long customerId, Costomer newCustomer) {
        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        session.update(newCustomer);
        session.getTransaction().commit();
        session.close();

        //return supplier;

        // update customer with id = :customerId to newCustomer
    }

    public List<Order> findAllOrders(Long customerId, OrderStatus orderStatus) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        List<Order> supplier = session.createQuery("FROM Order ").getResultList();
        session.getTransaction().commit();
        session.close();

        return supplier;

        // find all orders by :orderStatus where customer id = :customerId
        //return null;
    }

    public List<Costomer> findAll() {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        List<Costomer> supplier = session.createQuery("FROM Costomer ").getResultList();
        session.getTransaction().commit();
        session.close();

        return supplier;



        // return all customers from database
        //return null;
    }

    public Costomer findById(Long customerId) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        Costomer  costomer = session.get(Costomer.class,customerId);
        session.getTransaction().commit();
        session.close();

        return costomer;

        // find customer with id = :customerId from database and return it
        //return null;
    }

    public void deleteById(Long customerId) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        Costomer costomer = session.get(Costomer.class,customerId);
        session.delete(costomer);
        session.getTransaction().commit();
        session.close();

        // delete customer from database
    }
}
