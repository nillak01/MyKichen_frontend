package com.example.mykitchen.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.R;
import com.example.mykitchen.adapter.AllRecipeAdapter;
import com.example.mykitchen.adapter.RecipeListAdapter;
import com.example.mykitchen.domain.Recipe;
import com.example.mykitchen.rest.DeviceApiVolley;
import com.example.mykitchen.rest.RecipeApiVolley;


public class RecipeFragment extends Fragment {


    private RecyclerView rvFullRecipe;
    private RecipeListAdapter recipeListAdapter;
    private RecipeApiVolley recipeApiVolley;

    private AppCompatButton btnSaveRecipe;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);


        Recipe recipe =  (Recipe) getArguments().getSerializable(AllRecipeAdapter.ALL_RECIPE);

        btnSaveRecipe =  view.findViewById(R.id.btn_save_recipe);


        rvFullRecipe = view.findViewById(R.id.rv_full_recipe);
        recipeListAdapter = new RecipeListAdapter(getContext(), recipe);
        rvFullRecipe.setAdapter(recipeListAdapter);



        btnSaveRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new RecipeApiVolley(getContext()).updateRecipe(
                        recipe.getId(),  recipe.getName(), true,
                        recipe.getPoint_1(), recipe.getPoint_2(),recipe.getPoint_3(),recipe.getPoint_4(),
                        recipe.getPoint_5(),recipe.getPoint_6(),recipe.getPoint_7(),recipe.getPoint_8(),recipe.getPoint_9(),
                        recipe.getPoint_10()
                );

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(RecipeFragment.this)
                        .commit();
            }
        });

        return view;
    }
}