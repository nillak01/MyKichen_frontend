package com.example.mykitchen.domain;

public class Products {

    private int id;

    private String name;

    private boolean my;

    private int weight;

    public Products(int id, String name, boolean my, int weight) {
        this.id = id;
        this.name = name;
        this.my = my;
        this.weight = weight;
    }

    public Products(String name, boolean my, int weight) {
        this.name = name;
        this.my = my;
        this.weight = weight;
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

    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", my=" + my +
                ", weight=" + weight +
                '}';
    }
}
