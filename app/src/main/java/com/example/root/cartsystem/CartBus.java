package com.example.root.cartsystem;

import android.support.design.widget.AppBarLayout;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;


public class CartBus {
    public static PublishSubject<String> cart_data = PublishSubject.create();

    public static PublishSubject<String> getCart_data() {
        return cart_data;
    }
}
