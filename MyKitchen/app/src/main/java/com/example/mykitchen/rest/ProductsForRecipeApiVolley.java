package com.example.mykitchen.rest;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mykitchen.MyProductsActivity;
import com.example.mykitchen.MyRecipeActivity;
import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.domain.Device;
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.domain.ProductsForRecipe;
import com.example.mykitchen.domain.Recipe;
import com.example.mykitchen.domain.mapper.DeviceMapper;
import com.example.mykitchen.domain.mapper.ProductsForRecipeMapper;
import com.example.mykitchen.domain.mapper.ProductsMapper;
import com.example.mykitchen.domain.mapper.RecipeMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductsForRecipeApiVolley implements ProductsForRecipeApi{


    private final Context context;


    public static final String BASE_URL = "http://192.168.0.103:8081";

    public ProductsForRecipeApiVolley(Context context) { this.context = context; }


    @Override
    public void fillProductsForRecipe() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/products_for_recipe";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            NoDB.PRODUCTS_FOR_RECIPE_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Recipe recipe = new RecipeMapper().recipeFromPFRJson(jsonObject);

                                Products products = new ProductsMapper().productsFromPFRJson(jsonObject);

                                ProductsForRecipe productsForRecipe = new ProductsForRecipeMapper().productsForRecipeFromJson(jsonObject, recipe, products);
                                NoDB.PRODUCTS_FOR_RECIPE_LIST.add(productsForRecipe);
                            }
                            Log.d("PRODUCTS_F_R_LIST", NoDB.PRODUCTS_FOR_RECIPE_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("PRODUCTS_F_R_LIST_ERROR", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("PRODUCTS_F_R_ERROR", NoDB.PRODUCTS_FOR_RECIPE_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);


    }


    @Override
    public void fillProductsForRecipeByRecipeId(int recipe_id) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/device_for_recipe" + "/" + recipe_id;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            NoDB.PRODUCTS_FOR_RECIPE_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Recipe recipe = new RecipeMapper().recipeFromDFRJson(jsonObject);

                                Products products = new ProductsMapper().productsFromJson(jsonObject);

                                ProductsForRecipe productsForRecipe = new ProductsForRecipeMapper().productsForRecipeFromJson(jsonObject, recipe, products);
                                NoDB.PRODUCTS_FOR_RECIPE_LIST.add(productsForRecipe);
                            }

                            ((MyProductsActivity)context).updateAdapter();
                            Log.d("PRODUCTS_F_R_LIST", NoDB.PRODUCTS_FOR_RECIPE_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("PRODUCTS_F_R_LIST_ERROR", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("PRODUCTS_F_R_ERROR", NoDB.PRODUCTS_FOR_RECIPE_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);



    }
}
