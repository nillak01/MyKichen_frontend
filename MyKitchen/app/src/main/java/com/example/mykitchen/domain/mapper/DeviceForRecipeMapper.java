package com.example.mykitchen.domain.mapper;

import com.example.mykitchen.domain.DeviceForRecipe;

import org.json.JSONException;
import org.json.JSONObject;

public class DeviceForRecipeMapper {

    public static DeviceForRecipe deviceForRecipeFromJson(JSONObject jsonObject){

        DeviceForRecipe deviceForRecipe = null;

        try {
            deviceForRecipe = new DeviceForRecipe(
                    jsonObject.getInt("id"),
                    RecipeMapper.recipeFromJson(jsonObject),
                    DeviceMapper.deviceFromJson(jsonObject)


            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return deviceForRecipe;
    }
}
