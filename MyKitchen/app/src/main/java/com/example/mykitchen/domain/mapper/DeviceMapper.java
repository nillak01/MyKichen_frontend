package com.example.mykitchen.domain.mapper;

import com.example.mykitchen.domain.Device;

import org.json.JSONException;
import org.json.JSONObject;

public class DeviceMapper {

    public static Device deviceFromJson(JSONObject jsonObject){

        Device device = null;

        try {
            device = new Device(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getBoolean("my")

            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return device;


    }

    public static Device deviceFromDFRJson(JSONObject jsonObject){


        Device device1 = null;

        try {
            device1 = new Device(

                    jsonObject.getJSONObject("deviceDto").getInt("id"),
                    jsonObject.getJSONObject("deviceDto").getString("name"),
                    jsonObject.getJSONObject("deviceDto").getBoolean("my")

            );
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return device1;
    }
}
