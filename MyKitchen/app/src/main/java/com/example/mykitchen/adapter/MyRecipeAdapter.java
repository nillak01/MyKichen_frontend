package com.example.mykitchen.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.R;
import com.example.mykitchen.domain.DeviceForRecipe;
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.domain.ProductsForRecipe;
import com.example.mykitchen.domain.Recipe;
import com.example.mykitchen.fragment.AddProductFragment;
import com.example.mykitchen.fragment.MyRecipeFragment;

import java.util.List;

public class MyRecipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final String MY_RECIPE = "My_recipe";
    private final Context context;
    private final LayoutInflater layoutInflater;
    private final List<Recipe> recipeList;
    private final List<DeviceForRecipe> deviceForRecipeList;
    private final List<ProductsForRecipe> productsForRecipes;

    public MyRecipeAdapter(Context context,  List<Recipe> recipeList, List<DeviceForRecipe> deviceForRecipeList, List<ProductsForRecipe> productsForRecipes) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.recipeList = recipeList;
        this.deviceForRecipeList = deviceForRecipeList;
        this.productsForRecipes = productsForRecipes;

    }



    private class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvNeedDevices;
        private TextView tvNeedProducts;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_recipe_name);
            tvNeedDevices = itemView.findViewById(R.id.tv_recipe_devices);
            tvNeedProducts = itemView.findViewById(R.id.tv_recipe_products);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recipe_item, parent, false);
        return new MyRecipeAdapter.MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Recipe recipe = NoDB.RECIPE_LIST.get(position);
        String devices = deviceListString(position);
        String products = productsListString(position);


        ((MyRecipeAdapter.MyHolder)holder).tvName.setText(recipe.getName());
        ((MyRecipeAdapter.MyHolder) holder).tvNeedDevices.setText(devices);
        ((MyRecipeAdapter.MyHolder) holder).tvNeedProducts.setText(products);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyRecipeFragment myRecipeFragment = new MyRecipeFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable(MY_RECIPE, recipe);

                myRecipeFragment.setArguments(bundle);

                ((AppCompatActivity)context).getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_my_recipe, myRecipeFragment)
                        .commit();

            }
        });

    }

    @Override
    public int getItemCount() {

        return NoDB.RECIPE_LIST.size();
    }
    private String deviceListString(int position) {

        Recipe recipe = NoDB.RECIPE_LIST.get(position);
        List<DeviceForRecipe> deviceForRecipe = NoDB.DEVICE_FOR_RECIPE_LIST;
        String devices = "Необходимые приборы: ";
        boolean myAll = true;

        for (int i = 0; i < deviceForRecipe.size(); i++) {
            try {

                Recipe recipe1 = deviceForRecipe.get(i).getRecipe();
                if (deviceForRecipe.get(i).getRecipe().getId() == recipe.getId() && !deviceForRecipe.get(i).getDevice().isMy()) {

                    devices = devices + deviceForRecipe.get(i).getDevice().getName() + ", ";
                    myAll = false;
                }


            } catch (Exception e) {
                Toast.makeText(context, "Не хватает связей между рецептами и и продуктами или приборами", Toast.LENGTH_LONG);
            }


        }
        if (myAll) {
            devices += "  Все есть!";
        }


        return devices;
    }

    private String productsListString(int position) {

        Recipe recipe = NoDB.RECIPE_LIST.get(position);
        List<ProductsForRecipe> productsForRecipes = NoDB.PRODUCTS_FOR_RECIPE_LIST;
        String productsList = "Необходимые продукты: ";
        boolean myAll = true;


        for (int i = 0; i < productsForRecipes.size(); i++) {

            try {

                Recipe recipe1 = productsForRecipes.get(i).getRecipe();
                Products products1 = productsForRecipes.get(i).getProducts();
                int myWeight = productsForRecipes.get(i).getProducts().getWeight();
                int needWeight = productsForRecipes.get(i).getWeight();
                if (productsForRecipes.get(i).getRecipe().getId() == recipe.getId() && !products1.isMy()) {

                    if (myWeight < needWeight){

                        int void1 = needWeight - myWeight;
                        productsList = productsList + products1.getName() + ":  " + void1 + "  ,";

                    }else {

                        productsList = productsList + products1.getName() + ":  " + needWeight + "  ,";


                    }
                    myAll = false;

                }


            } catch (Exception e) {
                Toast.makeText(context, "Не хватает связей между рецептами и и продуктами или приборами", Toast.LENGTH_LONG);
            }


        }

        if (myAll) {
            productsList += "  Все есть!";
        }


        return productsList;
    }
}
