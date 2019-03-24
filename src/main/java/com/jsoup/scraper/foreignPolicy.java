package com.jsoup.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class foreignPolicy {

    public ArrayList<String> getTrendingURLs() {
        String URL = "https://foreignpolicy.com/";
        ArrayList<String> urlList = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect(URL).get();
            String title = doc.title();
            System.out.println(title);
            Elements content = doc.getElementsByClass("fp-trending-content");
            Elements attribute = content.select("a.hed-heading.-excerpt");
            Elements url = attribute.select("a[href]");
            for (Element link : url) {
                urlList.add(link.attr("abs:href"));
                System.out.println("Added the following link to list: " + link.attr("abs:href") + ".");
            }
        } catch (IOException e){
            System.out.checkError();
        }
        return urlList;
        }
    }
