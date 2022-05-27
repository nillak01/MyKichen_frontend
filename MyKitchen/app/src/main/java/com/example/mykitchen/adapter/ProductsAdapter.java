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
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.fragment.AddDeviceFragment;
import com.example.mykitchen.fragment.AddProductFragment;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final Context context;
    private final LayoutInflater layoutInflater;
    private final List<Products> productsList;

    public ProductsAdapter(Context context,  List<Products> productsList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.productsList = productsList;
    }


    private class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvWeight;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_products_name);
            tvWeight = itemView.findViewById(R.id.tv_products_weight);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.products_item, parent, false);
        return new ProductsAdapter.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Products products = NoDB.PRODUCTS_LIST.get(position);
        ((ProductsAdapter.MyHolder)holder).tvName.setText(products.getName());
        ((ProductsAdapter.MyHolder)holder).tvWeight.setText(String.valueOf(products.getWeight()) + " (гр)");



    }

    @Override
    public int getItemCount() {


        return NoDB.PRODUCTS_LIST.size();
    }
}
