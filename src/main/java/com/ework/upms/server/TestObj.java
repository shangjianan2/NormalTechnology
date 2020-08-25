package com.ework.upms.server;

public class TestObj {
    private Integer id;
    private String name;
    public TestObj() {
        this.id = -1;
        this.name = "--";
    }

    public TestObj(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("this is TestObj");
        System.out.printf("id = %d\r\n", this.id);
        System.out.printf("name = %s\r\n", this.name);
    }
}
