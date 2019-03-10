import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Starting Web Driver");

        // The Gecko Driver is required for driving FireFox, remember to add gecko to your environment PATH
        //variable and to configure the line below to reach the location of the gecko executable.
        //System.setProperty("webdriver.gecko.driver", "D:\\Projects\\github_repos\\news_reaction\\geckodriver.exe");



       ProfilesIni allProfiles = new ProfilesIni();
       FirefoxOptions options = new FirefoxOptions();
       FirefoxProfile driverProfile = allProfiles.getProfile("web_driver");
       options.setProfile(driverProfile);
       options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\Program_Files_Programming\\Gecko_Driver\\geckodriver.exe");

        System.out.println("Putting together the driver");

        WebDriver driver = new FirefoxDriver(options);


        driver.get("http://www.foreignpolicy.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
}
