package com.example.mykitchen.domain;

public class ProductsForRecipe {

    private int id;


    private Recipe recipe;

    private Products products;

    private int weight;

    public ProductsForRecipe(int id, Recipe recipe, Products products, int weight) {
        this.id = id;
        this.recipe = recipe;
        this.products = products;
        this.weight = weight;
    }

    public ProductsForRecipe(Recipe recipe, Products products, int weight) {
        this.recipe = recipe;
        this.products = products;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Products getProducts() {
        return products;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "ProductsForRecipe{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", products=" + products +
                ", weight=" + weight +
                '}';
    }
}
