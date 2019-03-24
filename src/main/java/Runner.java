import com.jsoup.scraper.foreignPolicy;

import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        foreignPolicy fpScraper = new foreignPolicy();
        ArrayList<String> fpTrendingUrls = fpScraper.getTrendingURLs();




        //        System.out.println("Starting Web Driver");
//
//        driverConfig configuration = new driverConfig();
//        fpRunner fpRunner = new fpRunner();
//
//        WebDriver driver = configuration.initFirefoxDriver();
//        fpRunner.fpDriver(driver);

    }
}
