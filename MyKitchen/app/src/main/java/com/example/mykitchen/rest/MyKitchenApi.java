package com.example.mykitchen.rest;

public interface MyKitchenApi {

    void fillDevice();

    void fillDeviceByMy(boolean my);

    void fillProducts();

    void fillProductsByMy(boolean my);

    void fillRecipe();

    void fillRecipeByMy(boolean my);

    void fillDeviceForRecipe();

    void fillDeviceForRecipeByRecipeId(int recipe_id);

    void fillProductsForRecipe();

    void fillProductsForRecipeByRecipeId(int recipe_id);

    void updateDevice(

            int id,
            String name,
            boolean my
    );

    void updateProducts(

            int id,
            String name,
            boolean my,
            int weight
    );

    void updateRecipe(

            int id,
            String name,
            boolean my,
            String point_1,
            String point_2,
            String point_3,
            String point_4,
            String point_5,
            String point_6,
            String point_7,
            String point_8,
            String point_9,
            String point_10


            );
}
