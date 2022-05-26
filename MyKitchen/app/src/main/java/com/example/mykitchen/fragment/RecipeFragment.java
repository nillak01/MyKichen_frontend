package com.example.mykitchen.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mykitchen.R;



public class RecipeFragment extends Fragment {

    private Button button_registration;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, ViewGroup viewGroup,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe,viewGroup,false);
        button_registration = view.findViewById(R.id.btn_recipe);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_recipe:

                }
            }
        };
        button_registration.setOnClickListener(listener);
        return view;
    }
}