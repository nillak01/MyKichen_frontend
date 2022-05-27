package com.example.mykitchen.domain.mapper;

import com.example.mykitchen.domain.DeviceForRecipe;
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.domain.ProductsForRecipe;
import com.example.mykitchen.domain.Recipe;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductsForRecipeMapper {

    public static ProductsForRecipe productsForRecipeFromJson(JSONObject jsonObject, Recipe recipe, Products products){

        ProductsForRecipe productsForRecipe = null;

        try {
            productsForRecipe = new ProductsForRecipe(
                    jsonObject.getInt("id"),
                    recipe,
                    products,
                    jsonObject.getInt("weight")


            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return productsForRecipe;
    }
}
