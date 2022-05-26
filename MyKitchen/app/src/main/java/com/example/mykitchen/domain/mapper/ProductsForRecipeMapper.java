package com.example.mykitchen.domain.mapper;

import com.example.mykitchen.domain.DeviceForRecipe;
import com.example.mykitchen.domain.ProductsForRecipe;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductsForRecipeMapper {

    public static ProductsForRecipe productsForRecipeFromJson(JSONObject jsonObject){

        ProductsForRecipe productsForRecipe = null;

        try {
            productsForRecipe = new ProductsForRecipe(
                    jsonObject.getInt("id"),
                    RecipeMapper.recipeFromJson(jsonObject),
                    ProductsMapper.productsFromJson(jsonObject),
                    jsonObject.getInt("weight")


            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return productsForRecipe;
    }
}
