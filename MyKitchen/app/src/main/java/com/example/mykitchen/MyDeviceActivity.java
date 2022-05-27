package com.example.mykitchen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.adapter.DeviceAdapter;
import com.example.mykitchen.domain.Device;
import com.example.mykitchen.domain.Products;
import com.example.mykitchen.fragment.AddDeviceFragment;
import com.example.mykitchen.rest.DeviceApiVolley;

import java.util.List;

public class MyDeviceActivity extends AppCompatActivity {

    private RecyclerView rvDevice;
    private DeviceAdapter deviceAdapter;
    private DeviceApiVolley deviceApiVolley;

    private Button btnAddDevice;


    private ItemTouchHelper.SimpleCallback simpleCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_device);



        deviceApiVolley = new DeviceApiVolley(this);
        deviceApiVolley.fillDeviceByMy(true);

        rvDevice = findViewById(R.id.rv_device);
        deviceAdapter = new DeviceAdapter(this, NoDB.DEVICE_LIST);
        rvDevice.setAdapter(deviceAdapter);

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

                Device device = NoDB.DEVICE_LIST.get(viewHolder.getAdapterPosition());

                if (direction == ItemTouchHelper.LEFT || direction == ItemTouchHelper.RIGHT){

                    deviceApiVolley.updateDevice(device.getId(), device.getName(),false );
                    deviceApiVolley.fillDeviceByMy(true);


                }
            }
        };




        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvDevice);


        btnAddDevice = findViewById(R.id.btn_add_device);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_add_device:
                        AddDeviceFragment addDeviceFragment = new AddDeviceFragment();

                        getSupportFragmentManager()
                                .beginTransaction()
                                .add(R.id.fl_device, addDeviceFragment)
                                .commit();
                        break;

                }

            }
        };
        btnAddDevice.setOnClickListener(listener);
    }

    public void updateAdapter(){

        deviceAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        if (fragmentList.size() > 0){

            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragmentList.get(fragmentList.size() - 1))
                    .commit();
            deviceApiVolley = new DeviceApiVolley(this);
            deviceApiVolley.fillDeviceByMy(true);
            updateAdapter();
        }else {

            finish();
        }
    }
}