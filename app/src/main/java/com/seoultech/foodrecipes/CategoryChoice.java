package com.seoultech.foodrecipes;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class CategoryChoice extends AppCompatActivity {

    ImageButton cheap, arrow_back,mood,low;
    Button cheap2,mood2,low2;
    Random random = new Random();
    int count1 = random.nextInt(5)+1;
    int count2 = random.nextInt(5)+1;
    int count3 = random.nextInt(5)+1;

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;


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

        myHelper = new myDBHelper(this);

        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        cheap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String foodnames = "";
//                sqlDB = myHelper.getReadableDatabase();
//                Cursor cursor;
//                cursor = sqlDB.rawQuery("SELECT Food.foodName, FoodIngredient.foodID, FoodIngredient.ingredient FROM Food, FoodIngredient WHERE FoodIngredient.foodID like'c%';", null);
//                while(cursor.moveToNext())
//                {
//                    for(int i=0; i<noEat.size();i++){
//                        if(noEat.get(i).equals(cursor.getString(2))){
//                            foodnames = foodnames + cursor.getString(0);
//                        }
//                    }
//                }
//                Toast.makeText(getApplicationContext(), foodnames,Toast.LENGTH_LONG).show();
                switch (count1){
                    case 1 :
                        Intent intent1 = new Intent(getApplicationContext(), meatball.class);
                        startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(getApplicationContext(), chickennugget.class);
                        startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(getApplicationContext(), budaestew.class);
                        startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(getApplicationContext(), red_bulgogi.class);
                        startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(getApplicationContext(), kimchi_fried_rice.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
        cheap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count1){
                    case 1 :
                        Intent intent1 = new Intent(getApplicationContext(), meatball.class);
                        startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(getApplicationContext(), chickennugget.class);
                        startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(getApplicationContext(), budaestew.class);
                        startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(getApplicationContext(), red_bulgogi.class);
                        startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(getApplicationContext(), kimchi_fried_rice.class);
                        startActivity(intent5);
                        break;
                }
            }
        });

        mood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count2){
                    case 1 :
                        Intent intent1 = new Intent(getApplicationContext(), gambas.class);
                        startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(getApplicationContext(), stake.class);
                        startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(getApplicationContext(), pasta.class);
                        startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(getApplicationContext(), marbled.class);
                        startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(getApplicationContext(), milfyunabe.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
        mood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count2){
                    case 1 :
                        Intent intent1 = new Intent(getApplicationContext(), gambas.class);
                        startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(getApplicationContext(), stake.class);
                        startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(getApplicationContext(), pasta.class);
                        startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(getApplicationContext(), marbled.class);
                        startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(getApplicationContext(), milfyunabe.class);
                        startActivity(intent5);
                        break;
                }
            }
        });


        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count3){
                    case 1 :
                        Intent intent1 = new Intent(getApplicationContext(), dobu.class);
                        startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(getApplicationContext(), kimchi.class);
                        startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(getApplicationContext(), eggjang.class);
                        startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(getApplicationContext(), carrotchicken.class);
                        startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(getApplicationContext(), pumpkin.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
        low2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count3){
                    case 1 :
                        Intent intent1 = new Intent(getApplicationContext(), dobu.class);
                        startActivity(intent1);
                        break;
                    case 2 :
                        Intent intent2 = new Intent(getApplicationContext(), kimchi.class);
                        startActivity(intent2);
                        break;
                    case 3 :
                        Intent intent3 = new Intent(getApplicationContext(), eggjang.class);
                        startActivity(intent3);
                        break;
                    case 4 :
                        Intent intent4 = new Intent(getApplicationContext(), carrotchicken.class);
                        startActivity(intent4);
                        break;
                    case 5 :
                        Intent intent5 = new Intent(getApplicationContext(), pumpkin.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
    }

    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper(Context context){
            super(context, "FoodReceipe", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE \"Food\" (\n" +
                    "\t\"foodID\"\tTEXT NOT NULL,\n" +
                    "\t\"foodName\"\tTEXT NOT NULL,\n" +
                    "\t\"drink\"\tTEXT,\n" +
                    "\tPRIMARY KEY(\"foodID\")\n" +
                    ")");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS Food");
            onCreate(db);
        }
    }

    private void processIntent(Intent intent){
        if(intent != null){
            ArrayList<String> noEat = (ArrayList<String>)intent.getSerializableExtra("noEat");
            if(noEat != null){
                Toast.makeText(getApplicationContext(),"전달받은 ArrayList의 첫번째 요소 :"+noEat.get(0),Toast.LENGTH_LONG).show();
            }
        }
    }
    public static final String ROOT_DIR = "/data/data/com.seoultech.foodrecipes/databases/";

    public static void setDB(Context ctx) {
        File folder = new File(ROOT_DIR);
        if(folder.exists()) {
        } else {
            folder.mkdirs();
        }
        AssetManager assetManager = ctx.getResources().getAssets();
        // db파일 이름 적어주기
        File outfile = new File(ROOT_DIR+"FoodRecipe.db");
        InputStream is = null;
        FileOutputStream fo = null;
        long filesize = 0;
        try {
            is = assetManager.open("FoodRecipe.db", AssetManager.ACCESS_BUFFER);
            filesize = is.available();
            if (outfile.length() <= 0) {
                byte[] tempdata = new byte[(int) filesize];
                is.read(tempdata);
                is.close();
                outfile.createNewFile();
                fo = new FileOutputStream(outfile);
                fo.write(tempdata);
                fo.close();
            } else {}
        } catch (IOException e) {

        }
    }
}
