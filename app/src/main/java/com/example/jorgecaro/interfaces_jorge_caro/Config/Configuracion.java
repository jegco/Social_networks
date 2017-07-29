package com.example.jorgecaro.interfaces_jorge_caro.Config;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorgecaro.interfaces_jorge_caro.MainActivity;
import com.example.jorgecaro.interfaces_jorge_caro.R;


public class Configuracion extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("");
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(R.string.configuracion);
        return inflater.inflate(R.layout.fragment_configuracion, container, false);
    }
}
