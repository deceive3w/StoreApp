package com.example.root.cartsystem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreHolder>{

    private List<String> data;
    StoreOnClickListener storeOnClickListener;

    public StoreAdapter(StoreOnClickListener storeOnClickListener,List<String> data){
        this.storeOnClickListener = storeOnClickListener;
        this.data = data;
    }
    @NonNull
    @Override
    public StoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_store_item,null);
        final StoreHolder storeHolder = new StoreHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeOnClickListener.buyItem(storeHolder.getAdapterPosition());
            }
        });
        storeHolder.tv_name_item.setHeight(100);
        return storeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoreHolder holder, int position) {
        holder.tv_name_item.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class StoreHolder extends RecyclerView.ViewHolder {
        TextView tv_name_item;
        public StoreHolder(View itemView) {
            super(itemView);
            tv_name_item = itemView.findViewById(R.id.store_item_name);
        }
    }
    interface StoreOnClickListener{
        void buyItem(int index);
    }
}

