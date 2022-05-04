package services;

import configuration.ConfigDB;
import models.Order;
import models.Supplier;
import org.hibernate.Session;
import java.util.List;

public class SupplierService {
    public void save(Supplier newSupplier) {

        Session session = ConfigDB.createSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(newSupplier);
        session.getTransaction().commit();
        session.close();
        System.out.println(" ADDED SUCCESSFULLY " + newSupplier);

        // write your code here
    }

    public void update(Long supplierId, Supplier newSupplier) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        session.update(newSupplier);
        session.getTransaction().commit();
        session.close();


        // write your code here
        // you should find supplier with id = :supplierId
        // and replace with newSupplier
    }

    public List<Supplier> findAllSuppliers() {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        List<Supplier> supplier = session.createQuery("FROM Supplier ").getResultList();
        session.getTransaction().commit();
        session.close();

        return supplier;

        // write your code here
        // you should find all suppliers and return them
       // return null;
    }

    public Supplier findById(Long supplierId) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
                session.getTransaction().begin();
                Supplier supplier = session.get(Supplier.class,supplierId);
                session.getTransaction().commit();
                session.close();

                return supplier;

        // write your code here
        // you should return supplier with id = :supplierId
        //return supplier;
    }

    public void getOrder(Long supplierId) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        //Supplier supplier =
                session.get(Supplier.class,supplierId);
        session.getTransaction().commit();
        session.close();

        //return supplier;


        // give free order to supplier with id = :supplierId
    }

    public void deleteById(Long supplierId) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        Supplier supplier = session.get(Supplier.class,supplierId);
        session.delete(supplier);
        session.getTransaction().commit();
        session.close();

        //return supplier;

        // write your code here
        // you should delete supplier with id = :supplierId
    }

    public List<Order> findAllOrders(Long supplierId) {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        List<Order> supplier = session.createQuery("FROM Order ").getResultList();
        session.getTransaction().commit();
        session.close();

        return supplier;
        // find all supplier's delivered orders

    }

    public List<Supplier> findAllBusySuppliers() {

        Session session = ConfigDB.createSessionFactory()
                .openSession();
        session.getTransaction().begin();
        List<Supplier> supplier = session.createQuery("FROM Supplier ").getResultList();
        session.getTransaction().commit();
        session.close();

        return supplier;
        // find all busy suppliers
    }

}
