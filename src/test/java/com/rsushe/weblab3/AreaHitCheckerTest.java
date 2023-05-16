package com.rsushe.weblab3;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AreaHitCheckerTest {
    private static final AreaHitChecker checker = new AreaHitChecker();

    @Test
    public void isHitRectangleCorrectDataReturnsTrue() {
        assertTrue(checker.isHitRectangle(1, 1, 5));
    }

    @Test
    public void isHitRectangleIncorrectDataReturnsFalse() {
        assertFalse(checker.isHitTriangle(10, 1, 5));
    }

    @Test
    public void isHitCircleCorrectDataReturnsTrue() {
        assertTrue(checker.isHitCircle(-1, -1, 5));
    }

    @Test
    public void isHitCircleIncorrectDataReturnsFalse() {
        assertFalse(checker.isHitCircle(1, -1, 5));
    }

    @Test
    public void isHitTriangleCorrectDataReturnsTrue() {
        assertTrue(checker.isHitTriangle(-1, 1, 5));
    }

    @Test
    public void isHitTriangleIncorrectDataReturnsFalse() {
        assertFalse(checker.isHitTriangle(1, 1, 5));
    }
}
