package peaksoft.dao;

import org.hibernate.*;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "CREATE TABLE IF NOT EXISTS users(" +
                            "id serial not null," +
                            "name VARCHAR(50) NOT NULL," +
                            "last_name VARCHAR(50) NOT NULL," +
                            "age int not null" +
                            ");";
            Query query = session.createSQLQuery(hql).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException ex) {
            System.out.println("create table de kata bar" + ex);
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            SQLQuery w = session.createSQLQuery("DROP TABLE IF EXISTS users").addEntity(User.class);
            w.executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException tg) {
            System.out.println("dropto kata bar" + tg);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User users = new User(name, lastName, age);
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(users);
            session.getTransaction().commit();
            session.close();
        } catch (Throwable tr) {
            System.out.println("save userste kata bar" + tr);
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            User user = (User)session.get(User.class,id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException throwable) {
            System.out.println("remove By id" + throwable);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> list = session.createQuery("FROM User").list();
            session.getTransaction().commit();
            session.close();
            System.out.println("Update+" + list.size());
            return list;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
//            System.out.println("ajdsla"+session);
        } catch (HibernateException e) {
            System.out.println("clean list" + e);
        }
    }
}

