package com.example.mykitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.adapter.DeviceAdapter;
import com.example.mykitchen.rest.DeviceApiVolley;

public class MyDeviceActivity extends AppCompatActivity {

    private RecyclerView rvDevice;
    private DeviceAdapter deviceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_device);


        new DeviceApiVolley(this).fillDeviceByMy(true);

        rvDevice = findViewById(R.id.rv_device);
        deviceAdapter = new DeviceAdapter(this, NoDB.DEVICE_LIST);
        rvDevice.setAdapter(deviceAdapter);
    }

    public void updateAdapter(){

        deviceAdapter.notifyDataSetChanged();
    }
}