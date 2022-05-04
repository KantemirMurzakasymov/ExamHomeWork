package services;

import configuration.ConfigDB;
import models.Order;
import models.Supplier;
import org.hibernate.Session;

import java.util.List;

public class OrderService {
    public void save(Order newOrder) {

        Session session = ConfigDB.createSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(newOrder);
        session.getTransaction().commit();
        session.close();
        System.out.println(" ADDED SUCCESSFULLY " + newOrder);

        // save a newOrder
    }

    public void update(Long orderId, Order newOrder) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        session.update(newOrder);
        session.getTransaction().commit();
        session.close();

        // update order with id = orderId
    }

    public List<Order> findAllOrders() {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        List<Order> supplier = session.createQuery("FROM Order ").getResultList();
        session.getTransaction().commit();
        session.close();

        return supplier;

        // find all orders
        //return null;
    }

    public Order findById(Long orderId) {
        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        Order order = session.get(Order.class,orderId);
        session.getTransaction().commit();
        session.close();

        return order;

        // find order by id from database and return it!
        //return null;
    }

    public void deleteById(Long orderId) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        Order order = session.get(Order.class,orderId);
        session.delete(order);
        session.getTransaction().commit();
        session.close();

        // delete order from database where id = :orderId
    }
}
