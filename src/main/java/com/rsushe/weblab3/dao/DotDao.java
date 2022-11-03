package com.rsushe.weblab3.dao;

import com.rsushe.weblab3.util.HibernateSessionFactoryUtil;
import com.rsushe.weblab3.entity.Dot;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "dotDao")
@ApplicationScoped
public class DotDao {
    public DotDao() {
        System.out.println("dot dao constructor");
    }

    public void saveDot(Dot dot) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dot);
        tx1.commit();
        session.close();
    }

    public void removeDotsBySessionId(String sessionId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete from dots where sessionId= :sessionId").setParameter("sessionId", sessionId).executeUpdate();
        session.getTransaction().commit();
    }
}
