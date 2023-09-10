package com.dayofmercury.applemusic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dayofmercury.applemusic.ui.lookaround.lookaroundFragment;
import com.dayofmercury.applemusic.ui.nowread.nowreadFragment;
import com.dayofmercury.applemusic.ui.radio.radioFragment;
import com.dayofmercury.applemusic.ui.search.searchFragment;
import com.dayofmercury.applemusic.ui.store.storeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    Fragment fragment_nowread;
    Fragment fragment_lookaround;
    Fragment fragment_radio;
    Fragment fragment_search;
    Fragment fragment_store;

    public void createimgview() throws IOException {
        ImageView imgview = findViewById(R.id.imgviewinsearch);
        Bitmap bitmap;
        URL url = new URL("https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/d2/4d/d6/d24dd66d-9054-5529-2b64-b7e9b23888e2/81121405.jpg/100x100bb.jpg");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setDoInput(true);
        conn.connect();

        InputStream is = conn.getInputStream();
        bitmap = BitmapFactory.decodeStream(is);

        imgview.setImageBitmap(bitmap);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Stuff that updates the UI
            }
        });

        fragment_nowread = new nowreadFragment();
        fragment_lookaround = new lookaroundFragment();
        fragment_radio = new radioFragment();
        fragment_store = new storeFragment();
        fragment_search = new searchFragment();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_nowRead,R.id.navigation_lookaround,R.id.navigation_radio,R.id.navigation_store,R.id.navigation_search)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch(item.getItemId()){
                    case R.id.bottom_nowread:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment_nowread).commit();
                        return true;
                    case R.id.bottom_lookaround:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment_lookaround).commit();
                        return true;
                    case R.id.bottom_radio:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment_radio).commit();
                        return true;
                    case R.id.bottom_store:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment_store).commit();
                        return true;
                    case R.id.bottom_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment_search).commit();
                        return true;
                }
                return false;
            }
        });
    }

}
