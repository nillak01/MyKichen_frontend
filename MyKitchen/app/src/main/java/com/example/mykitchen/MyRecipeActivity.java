package com.example.mykitchen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.adapter.MyRecipeAdapter;
import com.example.mykitchen.domain.Recipe;
import com.example.mykitchen.rest.MyRecipeApiVolley;
import com.example.mykitchen.rest.RecipeApiVolley;

import java.util.List;

public class MyRecipeActivity extends AppCompatActivity {

    private RecyclerView rvRecipe;
    private MyRecipeAdapter myRecipeAdapter;
    private MyRecipeApiVolley myRecipeApiVolley;

    private ItemTouchHelper.SimpleCallback simpleCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipe);


        myRecipeApiVolley = new MyRecipeApiVolley(this);
        myRecipeApiVolley.fillRecipeByMy(true);

        rvRecipe = findViewById(R.id.rv_my_recipe);
        myRecipeAdapter = new MyRecipeAdapter(this, NoDB.RECIPE_LIST, NoDB.DEVICE_FOR_RECIPE_LIST, NoDB.PRODUCTS_FOR_RECIPE_LIST);
        rvRecipe.setAdapter(myRecipeAdapter);

        simpleCallback = new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                Recipe recipe = NoDB.RECIPE_LIST.get(viewHolder.getAdapterPosition());

                if (direction == ItemTouchHelper.LEFT || direction == ItemTouchHelper.RIGHT){

                    myRecipeApiVolley.updateRecipe(recipe.getId(), recipe.getName(),false,
                            recipe.getPoint_1(),recipe.getPoint_2(),recipe.getPoint_3(),recipe.getPoint_4(),recipe.getPoint_5(),
                            recipe.getPoint_6(),recipe.getPoint_7(),recipe.getPoint_8(),recipe.getPoint_9(),recipe.getPoint_10());
                    myRecipeApiVolley.fillRecipeByMy(true);
                    updateAdapter();
                    myRecipeApiVolley.fillRecipeByMy(true);

                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvRecipe);
    }

    public void updateAdapter(){

        myRecipeAdapter.notifyDataSetChanged();
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