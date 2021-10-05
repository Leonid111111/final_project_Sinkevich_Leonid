import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    @BeforeClass
    public synchronized void setUp() {

        String browser = System.getProperty("browser");

        WebDriver driver;

        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "iexplore":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalStateException("Wrong browser");
            }
        }
        driver.get("https://demo.prestashop.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BasePage.setThreadLocalDriver(driver);
        driver.switchTo().frame("framelive");
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        BasePage.getDriver().quit();
        BasePage.getThreadLocalDriver().remove();

    }
}


