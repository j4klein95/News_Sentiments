package com.selenium.ff.drive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class driverConfig{
    /**Create a FireFox web driver. Returns WebDriver object.
     * @return WebDriver
     */
    public WebDriver initFirefoxDriver (){
        // The Gecko Driver is required for driving FireFox, remember to add gecko to your environment PATH
        //variable and to configure the line below to reach the location of the gecko executable.

        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile driverProfile = allProfiles.getProfile("web_driver");
        options.setProfile(driverProfile);

        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\Program_Files_Programming\\Gecko_Driver\\geckodriver.exe");

        /*For my mac Mac
//        options.setBinary("")
/*        System.setProperty("webdriver.gecko.driver", "geckodrivers/geckodriver");*/

        System.out.println("Putting together the driver");

        WebDriver driver = new FirefoxDriver(options);
        return driver;
    }
}
