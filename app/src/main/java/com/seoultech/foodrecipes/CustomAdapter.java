package com.seoultech.foodrecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    public ArrayList<bookMark> arrayList;
    public Context context;


    public CustomAdapter(ArrayList<bookMark> arrayList, StoreRecipe storeRecipe){
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getFoodImg())
                .into(holder.tv_foodImg);
        holder.tv_foodName.setText(arrayList.get(position).getFoodName());

//        database = FirebaseDatabase.getInstance();
//        databaseReference = database.getReference("BookMark");


//            holder.destory.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    databaseReference.removeValue();
//
//                    arrayList.remove(position);
//                    notifyItemRemoved(position);
//                    notifyItemRangeChanged(position, arrayList.size());
//                }
//            });


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView tv_foodImg;
        TextView tv_foodName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_foodImg = itemView.findViewById(R.id.tv_foodImg);
            this.tv_foodName = itemView.findViewById(R.id.tv_foodName);
        }
    }

}
