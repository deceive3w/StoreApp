package com.example.root.cartsystem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdpter extends FragmentStatePagerAdapter {
    int totalIndex;

    public PagerAdpter(FragmentManager fragmentManager, int totalIndex){
        super(fragmentManager);
        this.totalIndex = totalIndex;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case 0:
                fragment = new StoreFragment();
                break;
            case 1:
                fragment = new CartFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return totalIndex;
    }
}
