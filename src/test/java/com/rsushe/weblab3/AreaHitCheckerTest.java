package com.rsushe.weblab3;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AreaHitCheckerTest {
    private static final AreaHitChecker checker = new AreaHitChecker();

    @Test
    public void hitRectangle() {
        assertTrue(checker.isHitRectangle(1, 1, 5));
    }
}
