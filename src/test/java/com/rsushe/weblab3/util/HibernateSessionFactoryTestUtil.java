package com.rsushe.weblab3.util;

import com.rsushe.weblab3.entity.Dot;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryTestUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryTestUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate_test.cfg.xml");
                configuration.addAnnotatedClass(Dot.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
