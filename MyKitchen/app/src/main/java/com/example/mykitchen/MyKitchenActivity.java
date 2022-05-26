package com.example.mykitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyKitchenActivity extends AppCompatActivity {

    private Button myProducts;
    private Button myDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_kitchen);

        myProducts = findViewById(R.id.btn_my_products);
        myDevices = findViewById(R.id.btn_my_devices);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_my_products:
                        Intent intent = new Intent(MyKitchenActivity.this , MyProductsActivity.class);
                        MyKitchenActivity.this.startActivity(intent);
                        break;
                    case R.id.btn_my_devices:
                        Intent intent1 = new Intent(MyKitchenActivity.this , MyDeviceActivity.class);
                        MyKitchenActivity.this.startActivity(intent1);
                        break;

                }

            }
        };
        myProducts.setOnClickListener(listener);
        myDevices.setOnClickListener(listener);
    }
}