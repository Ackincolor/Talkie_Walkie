package com.ackincolor.talkiewalkie.services;

import com.ackincolor.talkiewalkie.entities.AndroidDevice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAndroidDevice {
    @GET("/devices")
    Call<List<AndroidDevice>> getAllAndroidDevice();
}
