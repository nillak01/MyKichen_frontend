package com.example.mykitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.adapter.DeviceAdapter;
import com.example.mykitchen.rest.DeviceApiVolley;
import com.example.mykitchen.rest.MyKitchenApiVolley;

public class MainActivity extends AppCompatActivity {



    private Button btn_recipe;
    private Button btn_my_recipe;
    private Button btn_My_kitchen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DeviceApiVolley(this).fillDeviceByMy(true);


        btn_recipe = findViewById(R.id.btn_recipe);
        btn_my_recipe = findViewById(R.id.btn_my_recipes);
        btn_My_kitchen = findViewById(R.id.btn_my_kichen);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_recipe:
                        Intent intent = new Intent(MainActivity.this , AllRecipeActivity.class);
                        MainActivity.this.startActivity(intent);
                        break;
                    case R.id.btn_my_recipes:
                        Intent intent1 = new Intent(MainActivity.this , MyRecipeActivity.class);
                        MainActivity.this.startActivity(intent1);
                        break;
                    case R.id.btn_my_kichen:
                        Intent intent2 = new Intent(MainActivity.this , MyKitchenActivity.class);
                        MainActivity.this.startActivity(intent2);
                        break;
                }

            }
        };
        btn_recipe.setOnClickListener(listener);
        btn_my_recipe.setOnClickListener(listener);
        btn_My_kitchen.setOnClickListener(listener);
    }


}