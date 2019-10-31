package com.ackincolor.talkiewalkie.controllers;

import android.util.Log;

import com.ackincolor.talkiewalkie.adapters.MyAndroidDeviceAdapter;
import com.ackincolor.talkiewalkie.entities.AndroidDevice;
import com.ackincolor.talkiewalkie.services.ServiceAndroidDevice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerAndroidDevice implements Callback<List<AndroidDevice>> {
    private MyAndroidDeviceAdapter androidDeviceAdapter;

    public ControllerAndroidDevice(MyAndroidDeviceAdapter androidDeviceAdapter) {
        this.androidDeviceAdapter = androidDeviceAdapter;
    }
    private String BASE_URL = "http://test.com";
    @Override
    public void onResponse(Call<List<AndroidDevice>> call, Response<List<AndroidDevice>> response) {
            this.androidDeviceAdapter.setData(response.body());
    }

    @Override
    public void onFailure(Call<List<AndroidDevice>> call, Throwable t) {

    }
    public void getAllDevices(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ServiceAndroidDevice service = retrofit.create(ServiceAndroidDevice.class);
        Call<List<AndroidDevice>> call = service.getAllAndroidDevice();
        call.enqueue(this);
        ArrayList<AndroidDevice> list= new ArrayList<>();
        list.add(new AndroidDevice("192.168.1.12","test","23"));
        list.add(new AndroidDevice("192.168.1.12","test","23"));
        list.add(new AndroidDevice("192.168.1.12","test","23"));
        this.androidDeviceAdapter.setData(list);
        Log.d("DEBUG","setting data");
    }
}
