package com.seoultech.foodrecipes;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StoreRecipe extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<bookMark> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    ImageButton arrow_back;
    Button destory;


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.store_receipe);

        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        arrow_back = findViewById(R.id.arrow_back);
        destory = findViewById(R.id.destory);



        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("BookMark");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    bookMark bookmark = snapshot1.getValue(bookMark.class);
                    arrayList.add(bookmark);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("StoreRecipe", String.valueOf(error.toException()));
            }
        });

        destory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.removeValue();
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        RecyclerDecoration_Height decoration_height = new RecyclerDecoration_Height(20);
        recyclerView.addItemDecoration(decoration_height);



        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);

        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public class RecyclerDecoration_Height extends RecyclerView.ItemDecoration{
        private final int divHeight;

        public RecyclerDecoration_Height(int divHeight){
            this.divHeight = divHeight;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state){
            super.getItemOffsets(outRect, view, parent, state);
            if(parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount()-1){
                outRect.bottom = divHeight;
            }
        }
    }
}
