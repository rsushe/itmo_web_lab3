package com.rsushe.weblab3.dao;

import com.rsushe.weblab3.util.HibernateSessionFactoryUtil;
import com.rsushe.weblab3.entity.Dot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "dotDao")
@ApplicationScoped
public class DotDao {

    private final SessionFactory sessionFactory;

    public DotDao() {
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    public DotDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveDot(Dot dot) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dot);
        tx1.commit();
        session.close();
    }

    public void removeDotsBySessionId(String sessionId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("delete from dots where sessionId= :sessionId").setParameter("sessionId", sessionId).executeUpdate();
        session.getTransaction().commit();
    }
}
