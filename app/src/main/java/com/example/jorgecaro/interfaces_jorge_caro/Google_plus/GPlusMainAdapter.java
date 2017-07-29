package com.example.jorgecaro.interfaces_jorge_caro.Google_plus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorgecaro.interfaces_jorge_caro.R;

public class GPlusMainAdapter extends Fragment {

    private static final String ARG_TITLE = "titulo";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_facebook_main_adapter, container, false);
    }

    public static Fragment getInstance(String titulo) {
        GPlusMainAdapter facebookMainAdapter = new GPlusMainAdapter();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE,titulo);
        facebookMainAdapter.setArguments(args);
        return facebookMainAdapter;
    }

}
