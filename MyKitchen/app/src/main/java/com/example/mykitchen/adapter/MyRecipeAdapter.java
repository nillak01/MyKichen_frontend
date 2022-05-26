package com.example.mykitchen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.R;
import com.example.mykitchen.domain.Recipe;

import java.util.List;

public class MyRecipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final LayoutInflater layoutInflater;
    private final List<Recipe> recipeList;

    public MyRecipeAdapter(Context context,  List<Recipe> recipeList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.recipeList = recipeList;

    }



    private class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_my_recipe_name);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.my_recipe_item, parent, false);


        return new MyRecipeAdapter.MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Recipe recipe = NoDB.RECIPE_LIST.get(position);
        ((MyRecipeAdapter.MyHolder)holder).tvName.setText(recipe.getName());

    }

    @Override
    public int getItemCount() {

        return NoDB.RECIPE_LIST.size();
    }
}
