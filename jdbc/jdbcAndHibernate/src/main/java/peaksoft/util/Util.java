package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String password = "123123";

    public static Connection connections() {
        Connection connection1 = null;
        try {
            connection1 = DriverManager.getConnection(url, user, password);
            System.out.println("PostgreSQL ге ийгиликтуу кошулдуу☻♥");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection1;
    }


//    private static final SessionFactory session = sessionByFactory();
//
//    private static SessionFactory sessionByFactory() {
//        try {
//            return new Configuration().configure("haibernate.cfg.xml").buildSessionFactory();
//        } catch (Throwable ex) {
//            System.out.println("sessiondo kata bar" + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }

//    public static SessionFactory getSessionFactory(){
//        return session;
//    }
//    public static void shutDown(){
//        session.close();
//    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~```
private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Properties prop = new Properties();


        prop.setProperty("connection.driver_class", "com.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "123123");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        org.hibernate.cfg.Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(peaksoft.model.User.class);
        cfg.addAnnotatedClass(peaksoft.model.User.class);
        cfg.setProperties(prop);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        System.out.println("Connected to hibernate");
        return cfg.buildSessionFactory(serviceRegistry);

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown() {
        getSessionFactory().close();
    }
}


