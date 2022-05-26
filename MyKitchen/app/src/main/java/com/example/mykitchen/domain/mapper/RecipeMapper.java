package com.example.mykitchen.domain.mapper;

import com.example.mykitchen.domain.Recipe;

import org.json.JSONException;
import org.json.JSONObject;

public class RecipeMapper {

    public static Recipe recipeFromJson(JSONObject jsonObject){

        Recipe recipe = null;

        try {
            recipe = new Recipe(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getBoolean("my"),
                    jsonObject.getString("point_1"),
                    jsonObject.getString("point_2"),
                    jsonObject.getString("point_3"),
                    jsonObject.getString("point_4"),
                    jsonObject.getString("point_5"),
                    jsonObject.getString("point_6"),
                    jsonObject.getString("point_7"),
                    jsonObject.getString("point_8"),
                    jsonObject.getString("point_9"),
                    jsonObject.getString("point_10")



                    );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipe;


    }

    public static Recipe recipeFromDFRJson(JSONObject jsonObject){


        Recipe recipe = null;

        try {
            recipe = new Recipe(

                    jsonObject.getJSONObject("recipeDto").getInt("id"),
                    jsonObject.getJSONObject("recipeDto").getString("name"),
                    jsonObject.getJSONObject("recipeDto").getBoolean("my"),
                    jsonObject.getJSONObject("recipeDto").getString("point_1"),
                    jsonObject.getJSONObject("recipeDto").getString("point_2"),
                    jsonObject.getJSONObject("recipeDto").getString("point_3"),
                    jsonObject.getJSONObject("recipeDto").getString("point_4"),
                    jsonObject.getJSONObject("recipeDto").getString("point_5"),
                    jsonObject.getJSONObject("recipeDto").getString("point_6"),
                    jsonObject.getJSONObject("recipeDto").getString("point_7"),
                    jsonObject.getJSONObject("recipeDto").getString("point_8"),
                    jsonObject.getJSONObject("recipeDto").getString("point_9"),
                    jsonObject.getJSONObject("recipeDto").getString("point_10")


                    );
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return recipe;
    }

    public static Recipe recipeFromPFRJson(JSONObject jsonObject){


        Recipe recipe = null;

        try {
            recipe = new Recipe(

                    jsonObject.getJSONObject("recipeDto").getInt("id"),
                    jsonObject.getJSONObject("recipeDto").getString("name"),
                    jsonObject.getJSONObject("recipeDto").getBoolean("my"),
                    jsonObject.getJSONObject("recipeDto").getString("point_1"),
                    jsonObject.getJSONObject("recipeDto").getString("point_2"),
                    jsonObject.getJSONObject("recipeDto").getString("point_3"),
                    jsonObject.getJSONObject("recipeDto").getString("point_4"),
                    jsonObject.getJSONObject("recipeDto").getString("point_5"),
                    jsonObject.getJSONObject("recipeDto").getString("point_6"),
                    jsonObject.getJSONObject("recipeDto").getString("point_7"),
                    jsonObject.getJSONObject("recipeDto").getString("point_8"),
                    jsonObject.getJSONObject("recipeDto").getString("point_9"),
                    jsonObject.getJSONObject("recipeDto").getString("point_10")


            );
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return recipe;
    }
}
