package com.rsushe.weblab3.util;

import com.rsushe.weblab3.entity.Dot;

import java.time.LocalDateTime;
import java.util.Random;

public class DataClassStubs {

    private static final String SESSION_ID_STUB = "session-id-stub";
    private static final Random random = new Random();
    public static Dot createDotStub(double x, double y, double r, boolean hit, LocalDateTime date) {
        return new Dot(SESSION_ID_STUB + random.nextInt(), x, y, r, hit, date, random.nextDouble());
    }

}
