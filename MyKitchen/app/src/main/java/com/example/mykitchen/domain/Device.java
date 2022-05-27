package com.example.mykitchen.domain;

import java.io.Serializable;

public class Device implements Serializable {


    private int id;

    private String name;

    private boolean my;

    public Device(int id, String name, boolean my) {
        this.id = id;
        this.name = name;
        this.my = my;
    }

    public Device(String name, boolean my) {
        this.name = name;
        this.my = my;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isMy() {
        return my;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", my=" + my +
                '}';
    }
}
