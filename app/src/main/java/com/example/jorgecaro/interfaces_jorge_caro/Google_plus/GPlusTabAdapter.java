package com.example.jorgecaro.interfaces_jorge_caro.Google_plus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_1Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_2Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_3Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Google_plus.Contenido.Contenido_1Google;
import com.example.jorgecaro.interfaces_jorge_caro.Google_plus.Contenido.Contenido_2Google;
import com.example.jorgecaro.interfaces_jorge_caro.Google_plus.Contenido.Contenido_3Google;

/**
 * Created by jorge caro on 5/19/2017.
 */

public class GPlusTabAdapter extends FragmentStatePagerAdapter {
    String[] titulos;

    public GPlusTabAdapter(FragmentManager fm, String[] titulos) {
        super(fm);
        this.titulos = titulos;
    }

    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Contenido_1Google();
            case 1: return new Contenido_2Google();
            case 2: return new Contenido_3Google();
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
