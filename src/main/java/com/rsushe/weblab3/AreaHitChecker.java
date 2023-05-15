package com.rsushe.weblab3;

public class AreaHitChecker implements HitChecker {
    @Override
    public boolean isPointHit(double x, double y, double r) {
        return isHitCircle(x, y, r) || isHitRectangle(x, y, r) || isHitTriangle(x, y, r);
    }

    protected boolean isHitCircle(double x, double y, double r) {
        return x <= 0 && y <= 0 && (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2));
    }

    protected boolean isHitRectangle(double x, double y, double r) {
        return x >= 0 && x <= r / 2 && y >= 0 && y <= r;
    }

    protected boolean isHitTriangle(double x, double y, double r) {
        return x <= 0 && y >= 0 && y - x - r <= 0;
    }
}
