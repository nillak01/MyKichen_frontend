package com.example.mykitchen.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mykitchen.MyProductsActivity;
import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.R;
import com.example.mykitchen.adapter.DeviceAdapter;
import com.example.mykitchen.adapter.DeviceSpinnerAdapter;
import com.example.mykitchen.adapter.ProductsAdapter;
import com.example.mykitchen.adapter.ProductsSpinnerAdapter;
import com.example.mykitchen.domain.Device;
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.rest.ProductsApiVolley;


public class AddProductFragment extends Fragment {


    private AppCompatSpinner spProducts;
    private ProductsSpinnerAdapter productsSpinnerAdapter;
    private AppCompatButton btnAddProduct;
    private EditText etWeight;
    private ProductsApiVolley productsApiVolley;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);


        productsApiVolley = new ProductsApiVolley(getContext());
        productsApiVolley.fillProducts();

        spProducts = view.findViewById(R.id.sp_product);
        btnAddProduct = view.findViewById(R.id.btn_add_product);
        etWeight = view.findViewById(R.id.add_weight);


        productsSpinnerAdapter = new ProductsSpinnerAdapter(getContext(), NoDB.PRODUCTS_LIST);


        spProducts.setAdapter(productsSpinnerAdapter );

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int weight = Integer.parseInt(etWeight.getText().toString());
                     new ProductsApiVolley(getContext()).updateProducts(
                             ((Products)spProducts.getSelectedItem()).getId()
                             , ((Products)spProducts.getSelectedItem()).getName(),
                             true,
                             weight

                     );
                }catch (NumberFormatException e){
                    Toast.makeText(getContext(), "Введен не верный формат массы", Toast.LENGTH_LONG);
                }
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(AddProductFragment.this)
                        .commit();

            }
        });


        return view;
    }
}