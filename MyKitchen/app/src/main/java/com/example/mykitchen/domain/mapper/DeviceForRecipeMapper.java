package com.example.mykitchen.domain.mapper;

import com.example.mykitchen.domain.Device;
import com.example.mykitchen.domain.DeviceForRecipe;
import com.example.mykitchen.domain.Recipe;

import org.json.JSONException;
import org.json.JSONObject;

public class DeviceForRecipeMapper {

    public static DeviceForRecipe deviceForRecipeFromJson(JSONObject jsonObject, Recipe recipe, Device device){

        DeviceForRecipe deviceForRecipe = null;

        try {
            deviceForRecipe = new DeviceForRecipe(
                    jsonObject.getInt("id"),
                    recipe,
                    device


            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return deviceForRecipe;
    }
}
