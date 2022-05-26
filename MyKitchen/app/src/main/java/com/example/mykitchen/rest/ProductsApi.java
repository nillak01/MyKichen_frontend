package com.example.mykitchen.rest;

public interface ProductsApi {

    void fillProducts();

    void fillProductsByMy(boolean my);

    void updateProducts(

            int id,
            String name,
            boolean my,
            int weight
    );
}
