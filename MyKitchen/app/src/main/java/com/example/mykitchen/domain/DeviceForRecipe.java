package com.example.mykitchen.domain;

public class DeviceForRecipe {

    private int id;

    private Recipe recipe;

    private Device device;

    public DeviceForRecipe(int id, Recipe recipe, Device device) {
        this.id = id;
        this.recipe = recipe;
        this.device = device;
    }

    public DeviceForRecipe(Recipe recipe, Device device) {
        this.recipe = recipe;
        this.device = device;
    }

    public int getId() {
        return id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Device getDevice() {
        return device;
    }

    @Override
    public String toString() {
        return "DeviceForRecipe{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", device=" + device +
                '}';
    }
}
