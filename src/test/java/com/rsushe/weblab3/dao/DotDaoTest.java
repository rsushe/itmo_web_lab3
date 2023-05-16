package com.rsushe.weblab3.dao;

import com.rsushe.weblab3.entity.Dot;
import com.rsushe.weblab3.util.DataClassStubs;
import com.rsushe.weblab3.util.HibernateSessionFactoryTestUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DotDaoTest {

    private static final Session session = HibernateSessionFactoryTestUtil.getSessionFactory().openSession();

    @Test
    public void saveDotTest() {
        Dot dotStub = DataClassStubs.createDotStub(1d, 2d, 3d, true, LocalDateTime.now());
        session.save(dotStub);
        List queryResult = session.createQuery("select d from dots d where sessionId = :sessionId")
                .setParameter("sessionId", dotStub.getSessionId()).list();
        assertEquals(queryResult.size(), 1);
        assertEquals(queryResult.get(0), dotStub);
    }

}
