package com.example.mykitchen.domain;

import java.io.Serializable;

public class Recipe  implements Serializable {


    private int id;


    private String name;

    private boolean my;


    private String point_1;

    private String point_2;

    private String point_3;

    private String point_4;

    private String point_5;

    private String point_6;

    private String point_7;

    private String point_8;

    private String point_9;

    private String point_10;

    public Recipe(int id, String name, boolean my, String point_1, String point_2, String point_3, String point_4, String point_5, String point_6, String point_7, String point_8, String point_9, String point_10) {
        this.id = id;
        this.name = name;
        this.my = my;
        this.point_1 = point_1;
        this.point_2 = point_2;
        this.point_3 = point_3;
        this.point_4 = point_4;
        this.point_5 = point_5;
        this.point_6 = point_6;
        this.point_7 = point_7;
        this.point_8 = point_8;
        this.point_9 = point_9;
        this.point_10 = point_10;
    }

    public Recipe(String name, boolean my, String point_1, String point_2, String point_3, String point_4, String point_5, String point_6, String point_7, String point_8, String point_9, String point_10) {
        this.name = name;
        this.my = my;
        this.point_1 = point_1;
        this.point_2 = point_2;
        this.point_3 = point_3;
        this.point_4 = point_4;
        this.point_5 = point_5;
        this.point_6 = point_6;
        this.point_7 = point_7;
        this.point_8 = point_8;
        this.point_9 = point_9;
        this.point_10 = point_10;
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

    public String getPoint_1() {
        return point_1;
    }

    public String getPoint_2() {
        return point_2;
    }

    public String getPoint_3() {
        return point_3;
    }

    public String getPoint_4() {
        return point_4;
    }

    public String getPoint_5() {
        return point_5;
    }

    public String getPoint_6() {
        return point_6;
    }

    public String getPoint_7() {
        return point_7;
    }

    public String getPoint_8() {
        return point_8;
    }

    public String getPoint_9() {
        return point_9;
    }

    public String getPoint_10() {
        return point_10;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", my=" + my +
                ", point_1='" + point_1 + '\'' +
                ", point_2='" + point_2 + '\'' +
                ", point_3='" + point_3 + '\'' +
                ", point_4='" + point_4 + '\'' +
                ", point_5='" + point_5 + '\'' +
                ", point_6='" + point_6 + '\'' +
                ", point_7='" + point_7 + '\'' +
                ", point_8='" + point_8 + '\'' +
                ", point_9='" + point_9 + '\'' +
                ", point_10='" + point_10 + '\'' +
                '}';
    }
}
