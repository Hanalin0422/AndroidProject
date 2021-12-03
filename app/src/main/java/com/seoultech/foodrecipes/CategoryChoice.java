package com.seoultech.foodrecipes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CategoryChoice extends AppCompatActivity {

    ImageButton cheap, arrow_back,mood,low;
    Button cheap2,mood2,low2;
    Random random = new Random();
    //int count1 = random.nextInt(5)+1;
    //int count2 = random.nextInt(5)+1;
    //int count3 = random.nextInt(5)+1;
    String[] count1 = {"1", "2", "3", "4", "5"};
    String[] count2 = {"1", "2", "3", "4", "5"};
    String[] count3 = {"1", "2", "3", "4", "5"};
    ArrayList<String> list1 = new ArrayList<>(Arrays.asList(count1));
    ArrayList<String> list2 = new ArrayList<>(Arrays.asList(count2));
    ArrayList<String> list3 = new ArrayList<>(Arrays.asList(count3));


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorychoice);

        final Intent intent = getIntent();
        final ArrayList<String> noEat = (ArrayList<String>)intent.getSerializableExtra("noEat");
        //processIntent(intent);

        cheap = (ImageButton)findViewById(R.id.cheap);
        cheap2 = (Button) findViewById(R.id.cheap2);
        mood = (ImageButton)findViewById(R.id.mood);
        mood2 = (Button)findViewById(R.id.mood2);
        low = (ImageButton)findViewById(R.id.low);
        low2 = (Button)findViewById(R.id.low2);
        arrow_back = (ImageButton)findViewById(R.id.arrow_back);

        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        for(int i=0; i<noEat.size(); i++){
            if(noEat.get(i).equals("돼지고기") || noEat.get(i).equals("양배추")){
                list1.set(2, "7");
            }
            if(noEat.get(i).equals("깻잎") || noEat.get(i).equals("돼지고기") || noEat.get(i).equals("양배추")){
                list1.set(3, "7");
            }
            if(noEat.get(i).equals("계란") || noEat.get(i).equals("김치")){
                list1.set(4, "7");
            }
        }

        list1.removeAll(Arrays.asList(String.valueOf("7")));
        if(list1 != null){
            Collections.shuffle(list1);
        }



        for(int i=0; i<noEat.size(); i++){
            if(noEat.get(i).equals("돼지고기") || noEat.get(i).equals("계란")){
                list2.set(1, "7");
            }
            if(noEat.get(i).equals("버섯") || noEat.get(i).equals("우유")){
                list2.set(2, "7");
            }
            if(noEat.get(i).equals("깻잎") || noEat.get(i).equals("버섯")){
                list2.set(3, "7");
                list2.set(4, "7");
            }
        }

        list2.removeAll(Arrays.asList(String.valueOf("7")));
        if(list2 != null){
            Collections.shuffle(list2);
        }



        for(int i=0; i<noEat.size(); i++){
            if(noEat.get(i).equals("계란") || noEat.get(i).equals("우유")){
                list3.set(0, "7");
            }
            if(noEat.get(i).equals("김치") || noEat.get(i).equals("계란")){
                list3.set(1, "7");
            }
            if(noEat.get(i).equals("계란")){
                list3.set(2, "7");
            }
            if(noEat.get(i).equals("당근") || noEat.get(i).equals("계란")){
                list3.set(3, "7");
            }
            if(noEat.get(i).equals("돼지고기")){
                list3.set(4, "7");
            }
        }

        list3.removeAll(Arrays.asList(String.valueOf("7")));
        if(list3 != null){
            Collections.shuffle(list3);
        }


        cheap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (list1.get(0)){
                    case "1" :
                        Intent intent1 = new Intent(getApplicationContext(), meatball.class);
                        startActivity(intent1);
                        break;
                    case "2" :
                        Intent intent2 = new Intent(getApplicationContext(), chickennugget.class);
                        startActivity(intent2);
                        break;
                    case "3" :
                        Intent intent3 = new Intent(getApplicationContext(), budaestew.class);
                        startActivity(intent3);
                        break;
                    case "4" :
                        Intent intent4 = new Intent(getApplicationContext(), red_bulgogi.class);
                        startActivity(intent4);
                        break;
                    case "5" :
                        Intent intent5 = new Intent(getApplicationContext(), kimchi_fried_rice.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
        cheap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (list1.get(0)){
                    case "1" :
                        Intent intent1 = new Intent(getApplicationContext(), meatball.class);
                        startActivity(intent1);
                        break;
                    case "2" :
                        Intent intent2 = new Intent(getApplicationContext(), chickennugget.class);
                        startActivity(intent2);
                        break;
                    case "3" :
                        Intent intent3 = new Intent(getApplicationContext(), budaestew.class);
                        startActivity(intent3);
                        break;
                    case "4" :
                        Intent intent4 = new Intent(getApplicationContext(), red_bulgogi.class);
                        startActivity(intent4);
                        break;
                    case "5" :
                        Intent intent5 = new Intent(getApplicationContext(), kimchi_fried_rice.class);
                        startActivity(intent5);
                        break;
                }
            }
        });

        mood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (list2.get(0)){
                    case "1" :
                        Intent intent1 = new Intent(getApplicationContext(), gambas.class);
                        startActivity(intent1);
                        break;
                    case "2" :
                        Intent intent2 = new Intent(getApplicationContext(), stake.class);
                        startActivity(intent2);
                        break;
                    case "3" :
                        Intent intent3 = new Intent(getApplicationContext(), pasta.class);
                        startActivity(intent3);
                        break;
                    case "4" :
                        Intent intent4 = new Intent(getApplicationContext(), marbled.class);
                        startActivity(intent4);
                        break;
                    case "5" :
                        Intent intent5 = new Intent(getApplicationContext(), milfyunabe.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
        mood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (list2.get(0)){
                    case "1" :
                        Intent intent1 = new Intent(getApplicationContext(), gambas.class);
                        startActivity(intent1);
                        break;
                    case "2" :
                        Intent intent2 = new Intent(getApplicationContext(), stake.class);
                        startActivity(intent2);
                        break;
                    case "3" :
                        Intent intent3 = new Intent(getApplicationContext(), pasta.class);
                        startActivity(intent3);
                        break;
                    case "4" :
                        Intent intent4 = new Intent(getApplicationContext(), marbled.class);
                        startActivity(intent4);
                        break;
                    case "5" :
                        Intent intent5 = new Intent(getApplicationContext(), milfyunabe.class);
                        startActivity(intent5);
                        break;
                }
            }
        });


        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list3.isEmpty()){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(CategoryChoice.this);
                    dlg.setTitle("레시피를 찾을 수가 없습니다");
                    dlg.setMessage("죄송해요ㅠㅠ 저희가 제공해드리는 레시피 중에 드실 수 있는게 없어요ㅠㅠ");
                    dlg.setIcon(R.drawable.app_icon);
                    dlg.setPositiveButton("확인", null);
                    dlg.setNegativeButton("처음으로 돌아가기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent1);
                        }
                    });
                    dlg.show();
                    //Toast.makeText(getApplicationContext(),"죄송해요ㅠㅠ 저희가 제공해드리는 레시피 중에 드실 수 있는게 없어요ㅠㅠ",Toast.LENGTH_SHORT).show();
                }else{
                    switch (list3.get(0)){
                        case "1" :
                            Intent intent1 = new Intent(getApplicationContext(), dobu.class);
                            startActivity(intent1);
                            break;
                        case "2" :
                            Intent intent2 = new Intent(getApplicationContext(), kimchi.class);
                            startActivity(intent2);
                            break;
                        case "3" :
                            Intent intent3 = new Intent(getApplicationContext(), eggjang.class);
                            startActivity(intent3);
                            break;
                        case "4" :
                            Intent intent4 = new Intent(getApplicationContext(), carrotchicken.class);
                            startActivity(intent4);
                            break;
                        case "5" :
                            Intent intent5 = new Intent(getApplicationContext(), pumpkin.class);
                            startActivity(intent5);
                            break;
                    }
                }

            }
        });
        low2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list3.isEmpty()){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(CategoryChoice.this);
                    dlg.setTitle("레시피를 찾을 수가 없습니다");
                    dlg.setMessage("죄송해요ㅠㅠ 저희가 제공해드리는 레시피 중에 드실 수 있는게 없어요ㅠㅠ");
                    dlg.setIcon(R.drawable.app_icon);
                    dlg.setPositiveButton("확인", null);
                    dlg.setNegativeButton("처음으로 돌아가기", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent1);
                        }
                    });
                    dlg.show();
                    //Toast.makeText(getApplicationContext(),"죄송해요ㅠㅠ 저희가 제공해드리는 레시피 중에 드실 수 있는게 없어요ㅠㅠ",Toast.LENGTH_SHORT).show();
                }else{
                    switch (list3.get(0)){
                        case "1" :
                            Intent intent1 = new Intent(getApplicationContext(), dobu.class);
                            startActivity(intent1);
                            break;
                        case "2" :
                            Intent intent2 = new Intent(getApplicationContext(), kimchi.class);
                            startActivity(intent2);
                            break;
                        case "3" :
                            Intent intent3 = new Intent(getApplicationContext(), eggjang.class);
                            startActivity(intent3);
                            break;
                        case "4" :
                            Intent intent4 = new Intent(getApplicationContext(), carrotchicken.class);
                            startActivity(intent4);
                            break;
                        case "5" :
                            Intent intent5 = new Intent(getApplicationContext(), pumpkin.class);
                            startActivity(intent5);
                            break;
                    }
                }

            }
        });
    }


    /*private void processIntent(Intent intent){
        if(intent != null){
            ArrayList<String> noEat = (ArrayList<String>)intent.getSerializableExtra("noEat");
            if(noEat != null){
                Toast.makeText(getApplicationContext(),"전달받은 ArrayList의 첫번째 요소 :"+noEat.get(0),Toast.LENGTH_LONG).show();
            }
        }
    }*/
}
