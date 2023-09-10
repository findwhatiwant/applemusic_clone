package com.dayofmercury.applemusic.ui.search;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.net.Uri;

import com.dayofmercury.applemusic.MainActivity;
import com.dayofmercury.applemusic.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class searchFragment extends Fragment {

    private searchViewModel searchViewModel;
    EditText edittext;
    View root;

    LinearLayout resultArea;


    TextView[] testtextview = {null, null, null, null, null};

    ImageView testimageview;

    private void searchModule(@NonNull String keyword){
        URL url = null;
        try {
            url = new URL("https://itunes.apple.com/search?term=" + keyword +"&media=music&limit=5");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            //System.out.println(urlConnection);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = urlConnection.getInputStream();

                        StringBuilder builder = new StringBuilder();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                        String line;

                        while ((line = reader.readLine()) != null) {
                            builder.append(line);
                        }

                        String result = builder.toString();
                        JSONObject jsonroot = new JSONObject(result);
                        JSONArray jsonarray = new JSONArray(jsonroot.getString("results"));
                        JSONObject[] finjsonobj = {jsonarray.getJSONObject(0),jsonarray.getJSONObject(1),jsonarray.getJSONObject(2),jsonarray.getJSONObject(3),jsonarray.getJSONObject(4)};

                        System.out.println(result);
                        for(int i=0; i<5; i++){
                            testtextview[i].setText(finjsonobj[i].getString("trackName"));
                        }



//                        testimageview.setImageResource(Integer.parseInt(finjsonobj.getString("artworkUrl60")));

                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(searchViewModel.class);
        root = inflater.inflate(R.layout.fragment_search, container, false);

        resultArea = root.findViewById(R.id.resultlayout);

        testtextview[0] = root.findViewById(R.id.textviewinsearch);
        testtextview[1] = root.findViewById(R.id.textviewinsearch2);
        testtextview[2] = root.findViewById(R.id.textviewinsearch3);
        testtextview[3] = root.findViewById(R.id.textviewinsearch4);
        testtextview[4] = root.findViewById(R.id.textviewinsearch5);
        testimageview = root.findViewById(R.id.imgviewinsearch);

        edittext = root.findViewById(R.id.edittext);
        edittext.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_ENTER:
//                        System.out.println(edittext.getText());
                        searchModule(edittext.getText().toString());
                        return true;
                }
                return false;
            }
        });


        return root;
    }


}
