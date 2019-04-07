import com.fopo.scraper.FoPoURLGrab;
import org.openqa.selenium.WebDriver;
import com.selenium.ff.drive.driverConfig;

import java.io.IOException;


public class Runner {

    public static void main(String[] args) throws IOException {
       //Setup Scrapers and Drivers
        driverConfig config = new driverConfig();
        WebDriver driver = config.initFirefoxDriver();
        FoPoURLGrab fpScraper = new FoPoURLGrab();

        //Grab FoPo trending Articles
        fpScraper.FoPoDriver(driver);
    }
}
