package com.example.mykitchen.rest;

public interface RecipeApi {

    void fillRecipe();

    void fillRecipeByMy(boolean my);

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
