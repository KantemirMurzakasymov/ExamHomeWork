package configuration;

import models.Adress;
import models.Costomer;
import models.Order;
import models.Supplier;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

public class ConfigDB {
    //release hibernate configuration here
    public static SessionFactory createSessionFactory() {

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgrasql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:8080/postgres");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "12345");

        properties.setProperty(Environment.HBM2DDL_AUTO, "create");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Adress.class);
        configuration.addAnnotatedClass(Costomer.class);
        configuration.addAnnotatedClass(Order.class);
        configuration.addAnnotatedClass(Supplier.class);

        return configuration.buildSessionFactory();

              // write configuration if you want use session factory
             // if you don't use this method then don't remove!
            //return null;
        }

        public static EntityManagerFactory createEntityManagerFactory() {
            // write entity manager configuration if you want use entity manager factory
            // if you don't use this method then don't remove!
            return null;
        }
}
