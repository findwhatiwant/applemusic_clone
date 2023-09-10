package com.dayofmercury.applemusic;

import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GenericLifecycleObserver;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;

/*
해결해야할 것 : 이미지 src 분리 후 이미지 뷰 삽임*/

public class Top25seoulActivity extends AppCompatActivity {

    private String url = "https://www.melon.com/chart/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top25seoul);

        LinearLayout ipttextlayout = (LinearLayout) findViewById(R.id.ipttextlayout);
        LinearLayout iptimglayout = (LinearLayout) findViewById(R.id.iptimagelayout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "pretendardmedium.ttf");

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,200);
        LinearLayout.LayoutParams linelp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,2);
        LinearLayout.LayoutParams imglp = new LinearLayout.LayoutParams(200,200);
        try {
            int count = 0;
            org.jsoup.nodes.Document doc = (org.jsoup.nodes.Document) Jsoup.connect(url).get();
            final Elements rank_list1 = doc.select(".wrap_song_info .ellipsis.rank01 span a");
            final Elements singer_list = doc.select(".wrap_song_info .elellipsis.rank02 a");
            final Elements img_list = doc.select("tr#lst50.lst50 div.wrap a.image_typeAll img ");
            for(Element element : rank_list1){
                if(count >= 25){
                    break;
                }

                TextView ipttextview = new TextView(this);
                TextView ipttextview2= new TextView(this);
                View lineview = new View(this);
                lineview.setLayoutParams(linelp);
                lineview.setBackgroundColor(Color.parseColor("#000000"));

                ipttextview.setText(count+1 + " " + element.text());
                ipttextview.setTextSize(20);
                ipttextview.setGravity(0x10);
                ipttextview.setTypeface(typeFace);
                ipttextview.setTextColor(Color.parseColor("#000000"));
                ipttextview.setLayoutParams(lp);

                ipttextlayout.addView(ipttextview, lp);
                ipttextlayout.addView(lineview);


                count++;
            }
            count = 0;
            for(Element element : img_list){
                count++;

                System.out.println(element.attr("src"));
                ImageView imgview = new ImageView(this);
                imgview.setLayoutParams(imglp);
//                imgview.setImageURI(Uri.parse(element.attr("src")));
                imgview.setPaddingRelative(20,22,22,10);

                Glide.with(iptimglayout.getContext()).load(element.attr("src").toString()).into(imgview);
                iptimglayout.addView(imgview);
                if(count >=25){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
