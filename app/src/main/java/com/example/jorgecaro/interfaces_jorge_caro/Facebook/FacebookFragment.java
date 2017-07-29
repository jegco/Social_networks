package com.example.jorgecaro.interfaces_jorge_caro.Facebook;

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

public class FacebookFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_facebook, container, false);

        if( ((MainActivity)getActivity()).getSupportActionBar() != null){
            ((MainActivity)getActivity()).getSupportActionBar().setElevation(0);
            ((MainActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.facebook);
            ((MainActivity)getActivity()).getSupportActionBar().getThemedContext().setTheme(R.style.faceb_theme);
        }
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FacebookTabAdapter(getActivity().getSupportFragmentManager(),new String[]{
                "", "", ""
        }));
        TabLayout tabs = (TabLayout) view.findViewById(R.id.tabs);
        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary_facebook));
        if(tabs != null){
            tabs.setupWithViewPager(viewPager);

            for(int i=0;i<tabs.getTabCount();i++){
                TabLayout.Tab tab = tabs.getTabAt(i);
                Drawable icon = null;
                switch (i){
                    case 0:
                        icon = ContextCompat.getDrawable(getActivity(),R.drawable.ic_insert_chart);
                        break;
                    case 1:
                        icon = ContextCompat.getDrawable(getActivity(),R.drawable.ic_action_globe);
                        break;
                    case 2:
                        icon = ContextCompat.getDrawable(getActivity(),R.drawable.ic_supervisor_account);
                        break;
                }
                if(tab != null){
                    tab.setIcon(icon);
                }
            }

        }

        return view;
    }

}
