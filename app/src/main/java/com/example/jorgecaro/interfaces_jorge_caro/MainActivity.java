package com.example.jorgecaro.interfaces_jorge_caro;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jorgecaro.interfaces_jorge_caro.Config.Configuracion;
import com.example.jorgecaro.interfaces_jorge_caro.Facebook.FacebookFragment;
import com.example.jorgecaro.interfaces_jorge_caro.Google_plus.GPlusFragment;
import com.example.jorgecaro.interfaces_jorge_caro.Inicio.InicioFragment;
import com.example.jorgecaro.interfaces_jorge_caro.Instagram.InstagramFragment;
import com.example.jorgecaro.interfaces_jorge_caro.R;
import com.example.jorgecaro.interfaces_jorge_caro.Twitter.TwitterFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    WebView wb;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    View header;
    LinearLayout nav_drawer_header;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);
        nav_drawer_header = (LinearLayout) header.findViewById(R.id.nav_drawer_header);
        nav_drawer_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        wb = new WebView(this);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.getSettings().setPluginState(WebSettings.PluginState.ON);
        wb.setWebViewClient(new WebViewClient());
        InicioFragment fragment_inicio =  new InicioFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, fragment_inicio,"tag").commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        SubMenu subMenu = menu.addSubMenu("version web");
        subMenu.add(R.string.facebook).setIcon(R.drawable.facebook).setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com")));
        subMenu.add(R.string.instagram).setIcon(R.drawable.instagram).setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com")));
        subMenu.add(R.string.twitter).setIcon(R.drawable.twitter).setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com")));
        subMenu.add(R.string.g_plus).setIcon(R.drawable.google_plus).setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("http://googleplus.com")));

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.compartir){
            dialogo_compartir().show();
        }
        if( id == R.id.configuracion){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, new Configuracion(),"Configuracion").commit();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            nav_drawer_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, new InicioFragment(),"tag").commit();
        } else if (id == R.id.nav_facebook) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary_facebook));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark_facebook));
            nav_drawer_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary_facebook));


            getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, new FacebookFragment(),"tag").commit();
        } else if (id == R.id.nav_instagram) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary_instgram));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark_instagram));
            nav_drawer_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary_instgram));
            getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, new InstagramFragment(),"tag").commit();
        } else if (id == R.id.nav_twitter) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary_twitter));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark_twitter));
            nav_drawer_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary_twitter));
            getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, new TwitterFragment(),"tag").commit();
        } else if (id == R.id.nav_g_plus) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary_google));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark_google));
            nav_drawer_header.setBackgroundColor(getResources().getColor(R.color.colorPrimary_google));
            getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, new GPlusFragment(),"tag").commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public AlertDialog dialogo_compartir(){
        final String[] items = {"Facebook", "Twitter", "Instagram", "Google Plus", "Whatsapp", "Messenger", "SMS"};
        final boolean[] checkedItems = {false, false, false, false, false, false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona dónde quieres compartir esta aplicación:");

        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });

        builder.setPositiveButton("Compartir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String seleccion = "Compartiste esta aplicación a través de: ";
                for (int i = 0; i < checkedItems.length; i++){
                    if(checkedItems[i]){
                        seleccion += "\n" + items[i];
                    }
                }
                dialog.cancel();
                dialogo_confirmacion(seleccion).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }

    public AlertDialog dialogo_confirmacion(final String seleccion){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmación");
        builder.setMessage("¿Compartir esta aplicación a través de los medios seleccionados?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(getApplicationContext(), seleccion, Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }
}
