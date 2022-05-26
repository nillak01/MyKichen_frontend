package com.example.mykitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.adapter.MyRecipeAdapter;
import com.example.mykitchen.rest.RecipeApiVolley;

public class MyRecipeActivity extends AppCompatActivity {

    private RecyclerView rvMyRecipe;
    private MyRecipeAdapter myRecipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipe);


        new RecipeApiVolley(this).fillRecipeByMy(true);

        rvMyRecipe = findViewById(R.id.rv_my_recipes);
        myRecipeAdapter = new MyRecipeAdapter(this, NoDB.RECIPE_LIST);
        rvMyRecipe.setAdapter(myRecipeAdapter);
    }

    public void updateAdapter(){

        myRecipeAdapter.notifyDataSetChanged();
    }
}