package com.seoultech.foodrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
            Toast.makeText(getApplicationContext(),"지도가 안나와",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            //e.printStackTrace();
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }

    }

    //Intent intent = getIntent();
}
