package com.example.jorgecaro.interfaces_jorge_caro.Instagram;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jorgecaro.interfaces_jorge_caro.MainActivity;
import com.example.jorgecaro.interfaces_jorge_caro.R;

public class InstagramFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_facebook, container, false);
        if( ((MainActivity)getActivity()).getSupportActionBar() != null){
            ((MainActivity)getActivity()).getSupportActionBar().setElevation(0);
            ((MainActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.instagram);
        }
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new InstagramTabAdapter(getActivity().getSupportFragmentManager(),new String[]{
                "", "", ""
        }));
        TabLayout tabs = (TabLayout) view.findViewById(R.id.tabs);
        if(tabs != null) {
            tabs.setupWithViewPager(viewPager);
            tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary_instgram));
            for (int i = 0; i < tabs.getTabCount(); i++) {
                TabLayout.Tab tab = tabs.getTabAt(i);
                Drawable icon = null;
                switch (i) {
                    case 0:
                        icon = ContextCompat.getDrawable(getActivity(), R.drawable.ic_action_search);
                        break;
                    case 1:
                        icon = ContextCompat.getDrawable(getActivity(), R.drawable.ic_camera_alt);
                        break;
                    case 2:
                        icon = ContextCompat.getDrawable(getActivity(), R.drawable.ic_action_heart);
                        break;
                }
                if (tab != null) {
                    tab.setIcon(icon);
                }
            }
        }

        return view;
    }

}
