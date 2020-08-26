package com.ework.upms.server.circle;

public class CircleB {
    private CircleA circleA;

    public CircleA getCircleA() {
        return circleA;
    }

    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }

    public void display() {
        System.out.println("this is circleB");
    }
}
