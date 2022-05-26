package com.example.mykitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.adapter.DeviceAdapter;
import com.example.mykitchen.adapter.ProductsAdapter;
import com.example.mykitchen.rest.DeviceApiVolley;
import com.example.mykitchen.rest.ProductsApiVolley;

public class MyProductsActivity extends AppCompatActivity {

    private RecyclerView rvRecipe;
    private ProductsAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipe);


        new ProductsApiVolley(this).fillProductsByMy(true);

        rvRecipe = findViewById(R.id.rv_my_products);
        productsAdapter = new ProductsAdapter(this, NoDB.PRODUCTS_LIST);
        rvRecipe.setAdapter(productsAdapter);
    }

    public void updateAdapter(){

        productsAdapter.notifyDataSetChanged();
    }
}