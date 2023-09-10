package com.dayofmercury.applemusic;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class jsoupModel {
    private String url = "https://www.melon.com/chart/index.htm";

    private Document getDocument(){
        try {
            org.jsoup.nodes.Document doc = (org.jsoup.nodes.Document) Jsoup.connect(url).get();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void run(){
        Document doc = getDocument();
        final Elements rank_list1 = doc.select("div.ellipsis rank01 span a");
        System.out.println(rank_list1);

    }

}
