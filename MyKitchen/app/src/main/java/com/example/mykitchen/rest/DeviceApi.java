package com.example.mykitchen.rest;

public interface DeviceApi {

    void fillDevice();

    void fillDeviceByMy(boolean my);

    void updateDevice(

            int id,
            String name,
            boolean my
    );
}
