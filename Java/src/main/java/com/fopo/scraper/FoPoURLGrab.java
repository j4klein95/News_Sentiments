package com.fopo.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FoPoURLGrab {

    public void FoPoDriver(WebDriver driver) throws IOException {
        ArrayList<String> commentURLs = getFoPoCommentURLs();
        for (String url : commentURLs) {
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
    }

    private ArrayList<String> getFoPoCommentURLs() throws IOException {
        ArrayList<String> trendingURLs = getFoPoTrendingURLs();
        ArrayList<String> commentUrls = new ArrayList<String>();
        for (String url : trendingURLs){
            Document doc = Jsoup.connect(url).get();
            Elements commentButtonDiv = doc.getElementsByClass("the-comments");
            Elements commentUrlsAttribute = commentButtonDiv.select("a[href]");
            for (Element link: commentUrlsAttribute) {
                commentUrls.add(link.attr("abs:href"));
            }
        }
        return commentUrls;
    }




    private ArrayList<String> getFoPoTrendingURLs() {
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
