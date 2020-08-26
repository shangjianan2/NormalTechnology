package com.ework.upms.server.circle;

public class CircleA {
    private CircleB circleB;
    private CircleC circleC;

    public CircleB getCircleB() {
        return circleB;
    }

    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }

    public CircleC getCircleC() {
        return circleC;
    }

    public void setCircleC(CircleC circleC) {
        this.circleC = circleC;
    }

    public void display() {
        System.out.println("this is circleA");
    }
}
