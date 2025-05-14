package org.example;

import org.example.config.PropertiesSessionFactoryProvider;
import org.example.config.SessionFactoryProvider;
import org.example.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SessionFactoryProvider provider = new PropertiesSessionFactoryProvider();
        SessionFactory sessionFactory = provider.getSessionFactory();
        
        //СОЗДАЛИ СУЩНОСТЬ ВНУТРИ JAVA
     //   User user = new User(20L, "mab1k", "pass");
        User user = new User(30L, "mab1k", "pass", "email123");

        //ЗАПИШЕМ СУЩНОСТЬ В БД
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(user); // СОХРАНИ В БД ЮЗЕРА
            transaction.commit();


        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
        // ПОЛУЧИЛИ СУЩНОСТЬ
        try(Session session = sessionFactory.openSession()){
            User gettedUser = session.get(User.class, 10);
            System.out.println(gettedUser);


        }catch (HibernateException e){
            throw new RuntimeException(e);
        }

        // УДАЛИМ СУЩНОСТЬ
        try(Session session = sessionFactory.openSession()){
//            Transaction transaction = session.beginTransaction();
//            session.remove(user);
//            transaction.commit();


        }catch (HibernateException e){
            throw new RuntimeException(e);
        }
    }
}