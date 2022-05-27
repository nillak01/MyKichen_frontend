package com.example.mykitchen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.adapter.DeviceAdapter;
import com.example.mykitchen.adapter.ProductsAdapter;
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.domain.Recipe;
import com.example.mykitchen.fragment.AddDeviceFragment;
import com.example.mykitchen.fragment.AddProductFragment;
import com.example.mykitchen.rest.DeviceApiVolley;
import com.example.mykitchen.rest.MyRecipeApiVolley;
import com.example.mykitchen.rest.ProductsApiVolley;

import java.util.List;

public class MyProductsActivity extends AppCompatActivity {

    private RecyclerView rvProducts;
    private ProductsAdapter productsAdapter;
    private ProductsApiVolley productsApiVolley;

    private Button button_add_products;

    private ItemTouchHelper.SimpleCallback simpleCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_products);


        productsApiVolley = new ProductsApiVolley(this);
        productsApiVolley.fillProductsByMy(true);

        rvProducts = findViewById(R.id.rv_my_products);
        productsAdapter = new ProductsAdapter(this, NoDB.PRODUCTS_LIST);
        rvProducts.setAdapter(productsAdapter);

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

                Products products = NoDB.PRODUCTS_LIST.get(viewHolder.getAdapterPosition());

                if (direction == ItemTouchHelper.LEFT || direction == ItemTouchHelper.RIGHT){

                    productsApiVolley.updateProducts(products.getId(), products.getName(),false, products.getWeight() );
                    productsApiVolley.fillProductsByMy(true);


                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvProducts);

        button_add_products = findViewById(R.id.btn_add_product);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_add_product:
                        AddProductFragment addProductFragment = new AddProductFragment();

                        getSupportFragmentManager()
                                .beginTransaction()
                                .add(R.id.fl_products, addProductFragment)
                                .commit();
                        break;

                }

            }
        };
        button_add_products.setOnClickListener(listener);
    }





    public void updateAdapter(){

        productsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        if (fragmentList.size() > 0){

            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragmentList.get(fragmentList.size() - 1))
                    .commit();

            productsApiVolley = new ProductsApiVolley(this);
            productsApiVolley.fillProductsByMy(true);
            updateAdapter();
        }else {

            finish();
        }
    }
}