package com.example.jorgecaro.interfaces_jorge_caro.Facebook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_1Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_2Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_3Facebook;

/**
 * Created by jorge caro on 5/19/2017.
 */

public class FacebookTabAdapter extends FragmentStatePagerAdapter {
    String[] titulos;

    public FacebookTabAdapter(FragmentManager fm, String[] titulos) {
        super(fm);
        this.titulos = titulos;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Contenido_1Facebook();
            case 1: return new Contenido_3Facebook();
            case 2 : return new Contenido_2Facebook();
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
