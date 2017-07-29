package com.example.jorgecaro.interfaces_jorge_caro.Twitter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_1Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_2Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_3Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Twitter.Contenido.Contenido_1Twitter;
import com.example.jorgecaro.interfaces_jorge_caro.Twitter.Contenido.Contenido_2Twitter;
import com.example.jorgecaro.interfaces_jorge_caro.Twitter.Contenido.Contenido_3Twitter;

/**
 * Created by jorge caro on 5/19/2017.
 */

public class TwitterTabAdapter extends FragmentStatePagerAdapter {
    String[] titulos;

    public TwitterTabAdapter(FragmentManager fm, String[] titulos) {
        super(fm);
        this.titulos = titulos;
    }

    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Contenido_1Twitter();
            case 1: return new Contenido_2Twitter();
            case 2: return new Contenido_3Twitter();
        }
        return null;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos[position];
    }
}
