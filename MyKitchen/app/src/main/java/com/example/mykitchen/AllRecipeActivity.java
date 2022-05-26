package com.example.mykitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.adapter.AllRecipeAdapter;
import com.example.mykitchen.rest.RecipeApiVolley;

public class AllRecipeActivity extends AppCompatActivity {

    private RecyclerView rvRecipe;
    private AllRecipeAdapter allRecipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipe);


        new RecipeApiVolley(this).fillRecipe();

        rvRecipe = findViewById(R.id.rv_all_recipe);
        allRecipeAdapter = new AllRecipeAdapter(this, NoDB.RECIPE_LIST);
        rvRecipe.setAdapter(allRecipeAdapter);
    }

    public void updateAdapter(){

        allRecipeAdapter.notifyDataSetChanged();
    }
}