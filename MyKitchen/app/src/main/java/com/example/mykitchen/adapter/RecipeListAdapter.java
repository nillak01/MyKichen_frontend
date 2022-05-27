package com.example.mykitchen.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.R;
import com.example.mykitchen.domain.Recipe;
import com.example.mykitchen.fragment.MyRecipeFragment;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final String RECIPE = "Recipe";
    private final Context context;
    private final LayoutInflater layoutInflater;
    private final Recipe recipe;

    public RecipeListAdapter(Context context,  Recipe recipe) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.recipe = recipe;

    }



    private class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_point);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.full_recipe_item, parent, false);
        return new RecipeListAdapter.MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        String[] all_points = new String[] {recipe.getPoint_1(), recipe.getPoint_2(), recipe.getPoint_3(), recipe.getPoint_4(),
                recipe.getPoint_5(), recipe.getPoint_6(),recipe.getPoint_7(),recipe.getPoint_8(),recipe.getPoint_9(),recipe.getPoint_10()};
        ((RecipeListAdapter.MyHolder)holder).tvName.setText(all_points[position]);


    }

    @Override
    public int getItemCount() {

        return 10;
    }
}
