package com.rsushe.weblab3.dao;

import com.rsushe.weblab3.util.HibernateSessionFactoryUtil;
import com.rsushe.weblab3.entity.Dot;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "dotDao")
@ApplicationScoped
public class DotDao {
    public DotDao() {
        System.out.println("dot dao constructor");
    }

    public List<Dot> findDotsBySessionId(String sessionId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Dot> criteria = builder.createQuery(Dot.class);
        Root<Dot> root = criteria.from(Dot.class);

        criteria.where(builder.equal(root.get("sessionId"), sessionId));
        return session.createQuery(criteria).getResultList();
    }

    public void saveDot(Dot dot) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dot);
        tx1.commit();
        session.close();
    }
}
