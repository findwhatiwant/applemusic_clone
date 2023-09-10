package com.dayofmercury.applemusic.ui.lookaround;

import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dayofmercury.applemusic.MainActivity;
import com.dayofmercury.applemusic.R;
import com.dayofmercury.applemusic.Top25seoulActivity;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class lookaroundFragment extends Fragment {


    private lookaroundViewModel lookaroundViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        lookaroundViewModel =
//                ViewModelProviders.of(this).get(lookaroundViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lookaround, container, false);

        View subroot = inflater.inflate(R.layout.activity_top25seoul, container, false);

        ImageButton imageButton = root.findViewById(R.id.top25button);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() , Top25seoulActivity.class);
                startActivity(intent);

            }
        });




        return root;
    }
}
