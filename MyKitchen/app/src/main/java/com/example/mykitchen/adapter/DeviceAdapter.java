package com.example.mykitchen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykitchen.NoDB.NoDB;
import com.example.mykitchen.R;
import com.example.mykitchen.domain.Device;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final LayoutInflater layoutInflater;
    private final List<Device> deviceList;

    public DeviceAdapter(Context context,  List<Device> deviceList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.deviceList = deviceList;
    }


    private class MyHolder extends RecyclerView.ViewHolder{

        private TextView tvName;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_device_name);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.device_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Device device = NoDB.DEVICE_LIST.get(position);
        ((MyHolder)holder).tvName.setText(device.getName());

    }

    @Override
    public int getItemCount() {


        return NoDB.DEVICE_LIST.size();
    }
}
