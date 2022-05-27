package com.example.mykitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.adapter.AllRecipeAdapter;
import com.example.mykitchen.rest.DeviceForRecipeApiVolley;
import com.example.mykitchen.rest.ProductsForRecipeApiVolley;
import com.example.mykitchen.rest.RecipeApiVolley;

import java.util.List;

public class AllRecipeActivity extends AppCompatActivity {

    private RecyclerView rvRecipe;
    private AllRecipeAdapter allRecipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipe);


        new RecipeApiVolley(this).fillRecipe();
        new DeviceForRecipeApiVolley(this).fillDeviceForRecipe();
        new ProductsForRecipeApiVolley(this).fillProductsForRecipe();

        rvRecipe = findViewById(R.id.rv_all_recipe);
        allRecipeAdapter = new AllRecipeAdapter(this, NoDB.RECIPE_LIST, NoDB.DEVICE_FOR_RECIPE_LIST, NoDB.PRODUCTS_FOR_RECIPE_LIST);
        rvRecipe.setAdapter(allRecipeAdapter);
    }

    public void updateAdapter(){

        allRecipeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        if (fragmentList.size() > 0){

            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragmentList.get(fragmentList.size() - 1))
                    .commit();
        }else {

            finish();
        }
    }
}