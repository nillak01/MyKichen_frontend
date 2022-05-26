package com.example.mykitchen.rest;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mykitchen.MyProductsActivity;
import com.example.mykitchen.MyRecipeActivity;
import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.domain.mapper.ProductsMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProductsApiVolley implements ProductsApi{


    private final Context context;


    public static final String BASE_URL = "http://192.168.0.103:8081";

    public ProductsApiVolley(Context context) { this.context = context; }


    @Override
    public void fillProducts() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/products";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            NoDB.PRODUCTS_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Products products = new ProductsMapper().productsFromJson(jsonObject);
                                NoDB.PRODUCTS_LIST.add(products);
                            }
                            Log.d("PRODUCTS_LIST", NoDB.PRODUCTS_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("PRODUCTS_LIST_ERROR!", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("PRODUCTS_LIST_ERROR", NoDB.PRODUCTS_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }


    @Override
    public void fillProductsByMy(boolean my) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/products" + "/" + my;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            NoDB.PRODUCTS_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Products products = new ProductsMapper().productsFromJson(jsonObject);
                                NoDB.PRODUCTS_LIST.add(products);
                            }
                            ((MyProductsActivity)context).updateAdapter();
                            Log.d("PRODUCTS_LIST", NoDB.PRODUCTS_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("PRODUCTS_LIST_ERROR!", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("PRODUCTS_LIST_ERROR", NoDB.PRODUCTS_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    @Override
    public void updateProducts(int id, String name, boolean my, int weight) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + "/products/" + id ;

        StringRequest postRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("Response", response);

                        //стоит обновлять локально
                        //но пока так
                        fillProducts();
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("PRODUCTS_ERROR", NoDB.PRODUCTS_LIST.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                params.put("id", String.valueOf(id));
                params.put("name", name);
                params.put("my", String.valueOf(my));
                params.put("weight", String.valueOf(weight));


                return params;
            }
        };

        queue.add(postRequest);


    }

}
