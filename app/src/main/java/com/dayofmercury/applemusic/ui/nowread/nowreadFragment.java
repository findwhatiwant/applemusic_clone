package com.dayofmercury.applemusic.ui.nowread;

import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dayofmercury.applemusic.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class nowreadFragment extends Fragment {

    private nowreadViewModel nowreadViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nowreadViewModel =
                ViewModelProviders.of(this).get(nowreadViewModel.class);
        View root = inflater.inflate(R.layout.fragment_nowread, container, false);

        GradientDrawable drawable = (GradientDrawable) getContext().getDrawable(R.drawable.textbackground);
        ImageView imageView = root.findViewById(R.id.album1);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);


        return root;
    }
}
