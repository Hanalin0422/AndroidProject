package com.seoultech.foodrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.MapView;

public class CloserMart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closermart);

        try{
            MapView mapView = new MapView(this);

            ViewGroup mapViewContainer = (ViewGroup)findViewById(R.id.map_view);
            mapViewContainer.addView(mapView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    Intent intent = getIntent();
}
