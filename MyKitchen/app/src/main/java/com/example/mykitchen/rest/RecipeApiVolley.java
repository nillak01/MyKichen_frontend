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
import com.example.mykitchen.AllRecipeActivity;
import com.example.mykitchen.MyRecipeActivity;
import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.domain.Recipe;
import com.example.mykitchen.domain.mapper.RecipeMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RecipeApiVolley implements RecipeApi{


    private final Context context;


    public static final String BASE_URL = "http://192.168.0.103:8081";

    public RecipeApiVolley(Context context) { this.context = context; }


    @Override
    public void fillRecipe() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/recipe";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            NoDB.RECIPE_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Recipe recipe = new RecipeMapper().recipeFromJson(jsonObject);
                                NoDB.RECIPE_LIST.add(recipe);
                            }
                            ((AllRecipeActivity)context).updateAdapter();
                            Log.d("RECIPE_LIST", NoDB.RECIPE_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("RECIPE_LIST_ERROR!", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("RECIPE_LIST_ERROR", NoDB.RECIPE_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);


    }


    @Override
    public void fillRecipeByMy(boolean my) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/recipe" + "/" + my;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            NoDB.RECIPE_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Recipe recipe = new RecipeMapper().recipeFromJson(jsonObject);
                                NoDB.RECIPE_LIST.add(recipe);
                            }
                            ((MyRecipeActivity)context).updateAdapter();
                            Log.d("RECIPE_LIST", NoDB.RECIPE_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("RECIPE_LIST_ERROR!", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("RECIPE_LIST_ERROR", NoDB.RECIPE_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);



    }

    @Override
    public void updateRecipe(int id, String name, boolean my, String point_1, String
            point_2, String point_3, String point_4, String point_5, String point_6, String
                                     point_7, String point_8, String point_9, String point_10) {


        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + "/recipe/" + id ;

        StringRequest postRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("Response", response);

                        //стоит обновлять локально
                        //но пока так
                        fillRecipe();
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("RECIPE_ERROR", NoDB.RECIPE_LIST.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                params.put("id", String.valueOf(id));
                params.put("name", name);
                params.put("my", String.valueOf(my));
                params.put("point_1", point_1);
                params.put("point_2", point_2);
                params.put("point_3", point_3);
                params.put("point_4", point_4);
                params.put("point_5", point_5);
                params.put("point_6", point_6);
                params.put("point_7", point_7);
                params.put("point_8", point_8);
                params.put("point_9", point_9);
                params.put("point_10", point_10);




                return params;
            }
        };

        queue.add(postRequest);

    }
}
