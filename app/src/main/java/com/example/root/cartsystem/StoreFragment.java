package com.example.root.cartsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment implements StoreAdapter.StoreOnClickListener {

    StoreAdapter storeAdapter;
    RecyclerView recyclerView_store_item;
    public StoreFragment() {
        // Required empty public constructor
    }

    List<String> data = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store,null);

        data.add("Jeruk");
        data.add("Kopi");
        data.add("Pisang");
        data.add("Roti");
        recyclerView_store_item = view.findViewById(R.id.rv_store);
        recyclerView_store_item.setAdapter(new StoreAdapter(this,data));
        recyclerView_store_item.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void buyItem(int index) {
        CartBus.getCart_data().onNext(data.get(index));
    }
}
