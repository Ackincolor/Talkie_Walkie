package com.ackincolor.talkiewalkie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ackincolor.talkiewalkie.adapters.MyAndroidDeviceAdapter;
import com.ackincolor.talkiewalkie.controllers.ControllerAndroidDevice;
import com.ackincolor.talkiewalkie.entities.AndroidDevice;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAndroidDeviceAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recuperation de la liste des appareils
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mAdapter = new MyAndroidDeviceAdapter(new ArrayList<AndroidDevice>());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(mAdapter);
        ControllerAndroidDevice controllerAndroidDevice = new ControllerAndroidDevice(mAdapter);
        controllerAndroidDevice.getAllDevices();
    }
}
