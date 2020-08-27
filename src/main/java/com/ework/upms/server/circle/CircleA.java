package com.ework.upms.server.circle;

public class CircleA {
    private CircleB circleB;
    private CircleC circleC;
    private Integer id = -1;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CircleA{" +
                "circleB=" + circleB +
                ", circleC=" + circleC +
                ", id=" + id +
                '}';
    }

    public void display() {
        System.out.println("this is circleA");
    }
}
