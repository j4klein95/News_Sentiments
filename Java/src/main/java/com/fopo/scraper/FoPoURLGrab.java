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
    /**Goes out to the comment URL's using web driver, scrapes each comment, appends to file (soon)
     * @param driver driver
     * @throws IOException
     */
    //TODO Go through each comment, append relevant information to already created CSV.
    public void FoPoDriver(WebDriver driver) throws IOException {
        //Get list of FoPo comment URL's
        ArrayList<String> commentURLs = getFoPoCommentURLs();

        //Travel to each comment section url, attach comments and relevant info to .txt
        for (String url : commentURLs) {
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
    }

    /**Grabs the url's of the FoPo comment section.
     * @return ArrayList<String> commentUrls
     * @throws IOException e
     */
    private ArrayList<String> getFoPoCommentURLs() throws IOException {
        //Create list of trending FoPo URL's
        ArrayList<String> trendingURLs = getFoPoTrendingURLs();

        //Create list object to add comment section links to.
        ArrayList<String> commentUrls = new ArrayList<String>();

        //For each article's URL, gather the URL for comment section, add to list
        for (String url : trendingURLs){
            Document doc = Jsoup.connect(url).get();
            Elements commentButtonDiv = doc.getElementsByClass("the-comments");
            Elements commentUrlsAttribute = commentButtonDiv.select("a[href]");
            for (Element link: commentUrlsAttribute) {
                commentUrls.add(link.attr("abs:href"));
            }
        }

        // return comment URL list
        return commentUrls;
    }


    /**Goes out and grabs Urls for FoPo top 10 trending articles
     * @return ArrayList<String> urlList
     */
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
