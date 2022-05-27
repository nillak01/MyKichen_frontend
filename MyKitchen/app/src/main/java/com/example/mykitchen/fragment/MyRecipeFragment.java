package com.example.mykitchen.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mykitchen.R;
import com.example.mykitchen.adapter.AllRecipeAdapter;
import com.example.mykitchen.adapter.MyRecipeAdapter;
import com.example.mykitchen.adapter.ProductsAdapter;
import com.example.mykitchen.adapter.RecipeListAdapter;
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.domain.Recipe;
import com.example.mykitchen.rest.RecipeApiVolley;


public class MyRecipeFragment extends Fragment {



    private RecyclerView rvFullRecipe;
    private RecipeListAdapter recipeListAdapter;
    private RecipeApiVolley recipeApiVolley;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_recipe, container, false);


        Recipe recipe =  (Recipe) getArguments().getSerializable(MyRecipeAdapter.MY_RECIPE);

        rvFullRecipe = view.findViewById(R.id.rv_full_recipe);
        recipeListAdapter = new RecipeListAdapter(getContext(), recipe);
        rvFullRecipe.setAdapter(recipeListAdapter);





        return view;
    }
}