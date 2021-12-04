package com.seoultech.foodrecipes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class budaestewRecipe extends AppCompatActivity {
    TabLayout tabLayout;
    FrameLayout frame1, frame2;
    TabItem food, drink;
    ImageButton goto_home, bookmark_add;
    Button mart;
    TextView text;
    ImageView imageView;

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budaestewrecipe);

        frame1 = (FrameLayout)findViewById(R.id.frame1);
        frame2 = (FrameLayout)findViewById(R.id.frame2);
        tabLayout = (TabLayout)findViewById(R.id.tab);
        goto_home = (ImageButton)findViewById(R.id.goto_home);
        bookmark_add = (ImageButton)findViewById(R.id.bookmark_add);
        mart = (Button)findViewById(R.id.mart);
        text = (TextView)findViewById(R.id.text1);
        imageView = (ImageView)findViewById(R.id.soju);


        Intent intent = getIntent();

        goto_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });

        mart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),CloserMart.class);
                startActivity(intent2);
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }
        });


        bookmark_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    writeData("c003","부대찌개", "https://firebasestorage.googleapis.com/v0/b/androidproject-9def8.appspot.com/o/budaestew.jpg?alt=media&token=a10ee75d-4855-4d01-9e8e-f77d14191d73");
                    Toast.makeText(getApplicationContext(),"저장되었습니다!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    //Toast.makeText(getApplicationContext(), e.toString() ,Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void changeView(int index){
        switch (index) {
            case 0:
                frame1.setVisibility(View.VISIBLE);
                frame2.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                text.setVisibility(View.VISIBLE);
                break;
            case 1:
                frame1.setVisibility(View.INVISIBLE);
                frame2.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void writeData(String foodID, String foodName, String foodImg){
        bookMark bookmark = new bookMark(foodID, foodName, foodImg);
        databaseReference.child("BookMark").child("Food_02").setValue(bookmark);
    }
}
