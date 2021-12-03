package com.seoultech.foodrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ImageButton viewStored;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox cabbage = (CheckBox) findViewById(R.id.cabbage);
        final CheckBox egg = (CheckBox) findViewById(R.id.egg);
        final CheckBox sesame = (CheckBox) findViewById(R.id.sesame);
        final CheckBox kimchi = (CheckBox) findViewById(R.id.kimchi);
        final CheckBox pork = (CheckBox) findViewById(R.id.pork);
        final CheckBox milk = (CheckBox) findViewById(R.id.milk);
        final CheckBox carrot = (CheckBox) findViewById(R.id.carrot);
        final CheckBox mushroom = (CheckBox) findViewById(R.id.mushroom);
        final CheckBox pumpkin = (CheckBox) findViewById(R.id.pumpkin);
        final CheckBox cucumber = (CheckBox) findViewById(R.id.cucumber);
        final CheckBox no = (CheckBox) findViewById(R.id.no);

        final Button noEatSubmit = (Button) findViewById(R.id.noEatSubmit);
        viewStored = (ImageButton) findViewById(R.id.viewStored);

        final ArrayList<String> postData = new ArrayList<String>(10);

        Intent intent = getIntent();

        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.seoultech.foodrecipes", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        cabbage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cabbage.isChecked() == true){
                    postData.add("양배추");
                }else{
                    postData.remove("양배추");
                }
            }
        });
        egg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(egg.isChecked() == true){
                    postData.add("계란");
                }else{
                    postData.remove("계란");
                }
            }
        });
        sesame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(sesame.isChecked() == true){
                    postData.add("깻잎");
                }else{
                    postData.remove("깻잎");
                }
            }
        });
        kimchi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(kimchi.isChecked()==true){
                    postData.add("김치");
                }else{
                    postData.remove("김치");
                }
            }
        });
        pork.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(pork.isChecked() == true){
                    postData.add("돼지고기");
                }else{
                    postData.remove("돼지고기");
                }
            }
        });
        milk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(milk.isChecked() == true){
                    postData.add("우유");
                }else{
                    postData.remove("우유");
                }
            }
        });
        carrot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(carrot.isChecked() == true){
                    postData.add("당근");
                }else{
                    postData.remove("당근");
                }
            }
        });
        mushroom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(mushroom.isChecked() == true){
                    postData.add("버섯");
                }else{
                    postData.remove("버섯");
                }
            }
        });
        pumpkin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(pumpkin.isChecked() == true){
                    postData.add("호박");
                }else{
                    postData.remove("호박");
                }
            }
        });
        cucumber.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cucumber.isChecked() == true){
                    postData.add("오이");
                }else{
                    postData.remove("오이");
                }
            }
        });
        no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(no.isChecked() == true){
                    postData.add("없음");
                }else{
                    postData.remove("없음");
                }
            }
        });


        noEatSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CategoryChoice.class);
                intent.putExtra("noEat", postData);
                startActivity(intent);
            }
        });

        viewStored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "아직 기능 안만듬", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
