package com.example.mykitchen.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mykitchen.MyDeviceActivity;
import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.R;
import com.example.mykitchen.adapter.DeviceAdapter;
import com.example.mykitchen.adapter.DeviceSpinnerAdapter;
import com.example.mykitchen.domain.Device;
import com.example.mykitchen.rest.DeviceApiVolley;


public class AddDeviceFragment extends Fragment {

    private AppCompatSpinner spDevice;
    private DeviceSpinnerAdapter deviceSpinnerAdapter;
    private AppCompatButton btnAdd;
    private DeviceApiVolley deviceApiVolley;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_device, container, false);


        deviceApiVolley = new DeviceApiVolley(getContext());
        deviceApiVolley.fillDeviceByMy(false);

        spDevice = view.findViewById(R.id.sp_device);
        btnAdd = view.findViewById(R.id.btn_add_device);


        deviceSpinnerAdapter = new DeviceSpinnerAdapter(getContext(), NoDB.DEVICE_LIST);


        spDevice.setAdapter(deviceSpinnerAdapter );

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DeviceApiVolley(getContext()).updateDevice(
                        ((Device)spDevice.getSelectedItem()).getId(),
                        ((Device)spDevice.getSelectedItem()).getName(),
                        true
                );

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(AddDeviceFragment.this)
                        .commit();


            }
        });


        return view;
    }
}