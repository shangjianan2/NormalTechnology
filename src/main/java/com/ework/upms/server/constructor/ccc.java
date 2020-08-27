package com.ework.upms.server.constructor;

public class ccc {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ccc() {
        this.id = -1;
        this.name = "--";
    }

    public ccc(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ccc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
