package com.rsushe.weblab3.dao;

import com.rsushe.weblab3.entity.Dot;
import com.rsushe.weblab3.util.DataClassStubs;
import com.rsushe.weblab3.util.HibernateSessionFactoryTestUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DotDaoTest {

    private static final SessionFactory sessionFactory = HibernateSessionFactoryTestUtil.getSessionFactory();
    private static final Session session = sessionFactory.openSession();
    private final DotDao dao = new DotDao(sessionFactory);

    @Test
    public void saveDotTestDotPersists() {
        Dot dotStub = DataClassStubs.createDotStub(1d, 2d, 3d, true, LocalDateTime.now());
        dao.saveDot(dotStub);
        List queryResult = session.createQuery("select d from dots d where sessionId = :sessionId")
                .setParameter("sessionId", dotStub.getSessionId()).list();
        assertEquals(1, queryResult.size());
        assertEquals(dotStub.getSessionId(), ((Dot) queryResult.get(0)).getSessionId());
        assertEquals(dotStub.getX(), ((Dot) queryResult.get(0)).getX());
        assertEquals(dotStub.getY(), ((Dot) queryResult.get(0)).getY());
        assertEquals(dotStub.getR(), ((Dot) queryResult.get(0)).getR());
        assertEquals(dotStub.isHit(), ((Dot) queryResult.get(0)).isHit());
        assertEquals(dotStub.getCreationDate(), ((Dot) queryResult.get(0)).getCreationDate());
        assertEquals(dotStub.getWorkingTime(), ((Dot) queryResult.get(0)).getWorkingTime());
    }

    @Test
    public void removeDotsBySessionIdCorrectlyRemovesDots() {
        String sessionId = "session-id-stub";
        Dot dotStub1 = DataClassStubs.createDotStub(sessionId, 1d, 2d, 3d, true, LocalDateTime.now());
        Dot dotStub2 = DataClassStubs.createDotStub(sessionId, 1d, 2d, 3d, true, LocalDateTime.now());
        session.persist(dotStub1);
        session.persist(dotStub2);
        dao.removeDotsBySessionId(sessionId);
        List queryResult = session.createQuery("select d from dots d where sessionId = :sessionId")
                .setParameter("sessionId", sessionId).list();
        assertEquals(0, queryResult.size());
    }
}
