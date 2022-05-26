package com.example.mykitchen.domain.mapper;

import com.example.mykitchen.domain.Products;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductsMapper {

    public static Products productsFromJson(JSONObject jsonObject){

        Products products = null;

        try {
            products = new Products(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getBoolean("my"),
                    jsonObject.getInt("weight")



            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return products;


    }

    public static Products productsFromPFRJson(JSONObject jsonObject){


        Products products = null;

        try {
            products = new Products(

                    jsonObject.getJSONObject("productsDto").getInt("id"),
                    jsonObject.getJSONObject("productsDto").getString("name"),
                    jsonObject.getJSONObject("productsDto").getBoolean("my"),
                    jsonObject.getJSONObject("productsDto").getInt("weight")

            );
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return products;
    }
}
