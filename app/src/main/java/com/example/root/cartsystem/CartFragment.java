package com.example.root.cartsystem;

import android.content.Context;
import android.net.Uri;
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

import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

public class CartFragment extends Fragment {


    public CartFragment() {
        // Required empty public constructor
    }
    List<String> data = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.rv_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        final StoreAdapter storeAdapter = new StoreAdapter(null,data);
        CartBus.getCart_data().doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                data.add(s);
                Log.d("doonrxt", "accept: "+s);
            }
        }).subscribe(new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                recyclerView.setAdapter(storeAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        // Inflate the layout for this fragment
        return view;
    }


}
