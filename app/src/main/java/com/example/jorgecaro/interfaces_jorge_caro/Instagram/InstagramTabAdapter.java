package com.example.jorgecaro.interfaces_jorge_caro.Instagram;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_1Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_2Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Facebook.Contenido.Contenido_3Facebook;
import com.example.jorgecaro.interfaces_jorge_caro.Instagram.Contenido.Contenido_1Instagram;
import com.example.jorgecaro.interfaces_jorge_caro.Instagram.Contenido.Contenido_2Instagram;
import com.example.jorgecaro.interfaces_jorge_caro.Instagram.Contenido.Contenido_3Instagram;

/**
 * Created by jorge caro on 5/19/2017.
 */

public class InstagramTabAdapter extends FragmentStatePagerAdapter {
    String[] titulos;

    public InstagramTabAdapter(FragmentManager fm, String[] titulos) {
        super(fm);
        this.titulos = titulos;
    }

    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Contenido_1Instagram();
            case 1: return new Contenido_2Instagram();
            case 2: return new Contenido_3Instagram();
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
