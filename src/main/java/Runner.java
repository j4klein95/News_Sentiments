
import org.openqa.selenium.WebDriver;


public class Runner {

    public static void main(String[] args) {

        System.out.println("Starting Web Driver");

        driverConfig configuration = new driverConfig();
        fpRunner fpRunner = new fpRunner();

        WebDriver driver = configuration.initFirefoxDriver();
        fpRunner.fpDriver(driver);

    }
}
