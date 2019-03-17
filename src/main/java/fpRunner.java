import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class fpRunner {

    public void fpDriver (WebDriver driver) {

        driver.get("http://www.foreignpolicy.com");

        driver.findElements(By.cssSelector(".g-block-wrapper"));
        List<WebElement> trendingStories = driver.findElements(By.className("fp-trending-content"));
        int numberOfTrendingStories = trendingStories.size();
        System.out.println("There are a total of " + numberOfTrendingStories + " stories.");

        for (WebElement url : trendingStories){
            String href = url.findElement(By.cssSelector("a")).getAttribute("href");
            System.out.println(href);
            driver.navigate().to(href);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.navigate().back();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
            //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        driver.close();

//        for (WebElement url : trendingStories) {
//            System.out.println(url.toString());
//            System.out.println(url.getText());
//            System.out.println(url.getTagName());
//            url.findElement(By.cssSelector("a[href]")).click();
//
////            url.findElement(By.cssSelector("a[href*='long]")).click();
////            url.click();
////            url.findElement(By.cssSelector(".the-comments > a:nth-child(1)"));
//        }
        //driver.close();

    }
}


//.g-block-wrapper > div:nth-child(2) > ol:nth-child(1)
