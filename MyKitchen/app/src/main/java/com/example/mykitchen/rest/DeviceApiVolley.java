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
import com.example.mykitchen.MainActivity;
import com.example.mykitchen.MyDeviceActivity;
import com.example.mykitchen.MyProductsActivity;
import com.example.mykitchen.MyRecipeActivity;
import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.domain.Device;
import com.example.mykitchen.domain.mapper.DeviceMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DeviceApiVolley implements DeviceApi{

    private final Context context;


    public static final String BASE_URL = "http://192.168.0.103:8081";

    public DeviceApiVolley(Context context) { this.context = context; }


    @Override
    public void fillDevice() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/device";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {



                        try {

                            NoDB.DEVICE_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Device device = new DeviceMapper().deviceFromJson(jsonObject);
                                NoDB.DEVICE_LIST.add(device);
                            }
                            ((MyDeviceActivity)context).updateAdapter();
                            Log.d("DEVICE_LIST", NoDB.DEVICE_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("DEVICE_LIST_ERROR!", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("DEVICE_LIST_ERROR", NoDB.DEVICE_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }

    @Override
    public void fillDeviceByMy(boolean my) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/device" + "/" + my ;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            NoDB.DEVICE_LIST.clear();
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Device device = new DeviceMapper().deviceFromJson(jsonObject);
                                NoDB.DEVICE_LIST.add(device);
                            }
                            ((MyDeviceActivity)context).updateAdapter();
                            Log.d("DEVICE_LIST", NoDB.DEVICE_LIST.toString());
                        } catch (JSONException e) {

                            Log.d("DEVICE_LIST_ERROR!", e.getMessage());
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("DEVICE_LIST_ERROR", NoDB.DEVICE_LIST.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }


    @Override
    public void updateDevice(int id, String name, boolean my) {

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + "/device/" + id ;

        StringRequest postRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("Response", response);

                        //стоит обновлять локально
                        //но пока так
                        fillDeviceByMy(true);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("DEVICE_ERROR", NoDB.DEVICE_LIST.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                params.put("id", String.valueOf(id));
                params.put("name", name);
                params.put("my", String.valueOf(my));


                return params;
            }
        };

        queue.add(postRequest);


    }

}
