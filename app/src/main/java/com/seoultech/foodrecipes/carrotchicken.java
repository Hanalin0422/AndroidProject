package com.seoultech.foodrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class carrotchicken extends AppCompatActivity {

    ImageButton arrow_back, goto_home, carrotchicken;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrotchicken);

        arrow_back = (ImageButton)findViewById(R.id.arrow_back);
        goto_home = (ImageButton)findViewById(R.id.goto_home);
        carrotchicken = (ImageButton)findViewById(R.id.carrotchicken);
        Intent intent = getIntent();

        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        goto_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
        carrotchicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), carrotchickenReceipe.class);
                startActivity(intent);
            }
        });
    }
}
