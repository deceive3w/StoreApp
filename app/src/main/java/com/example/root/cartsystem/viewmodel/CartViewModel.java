package com.example.root.cartsystem.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class CartViewModel extends ViewModel {
    MutableLiveData<String> response = new MutableLiveData<>();

}
