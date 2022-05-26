package com.example.mykitchen.rest;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.domain.DeviceForRecipe;
import com.example.mykitchen.domain.mapper.DeviceForRecipeMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceForRecipeApiVolley implements DeviceForRecipeApi{

    private final Context context;


    public static final String BASE_URL = "http://192.168.0.103:8081";

    public DeviceForRecipeApiVolley(Context context) { this.context = context; }


    @Override
    public void fillDeviceForRecipe() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/device_for_recipe";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            NoDB.DEVICE_FOR_RECIPE_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                DeviceForRecipe deviceForRecipe = new DeviceForRecipeMapper().deviceForRecipeFromJson(jsonObject);
                                NoDB.DEVICE_FOR_RECIPE_LIST.add(deviceForRecipe);
                            }
                            Log.d("DEVICE_FOR_RECIPE_LIST", NoDB.DEVICE_FOR_RECIPE_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("DEVICE_F_R_LIST_ERROR!", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("DEVICE_FOR_RECIPE_ERROR", NoDB.DEVICE_FOR_RECIPE_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);


    }


    @Override
    public void fillDeviceForRecipeByRecipeId(int recipe_id) {

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

                            NoDB.DEVICE_FOR_RECIPE_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                DeviceForRecipe deviceForRecipe = new DeviceForRecipeMapper().deviceForRecipeFromJson(jsonObject);
                                NoDB.DEVICE_FOR_RECIPE_LIST.add(deviceForRecipe);
                            }
                            Log.d("DEVICE_FOR_RECIPE_LIST", NoDB.DEVICE_FOR_RECIPE_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("DEVICE_F_R_LIST_ERROR!", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("DEVICE_FOR_RECIPE_ERROR", NoDB.DEVICE_FOR_RECIPE_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);



    }
}
