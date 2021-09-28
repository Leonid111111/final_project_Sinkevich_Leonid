import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    @BeforeMethod
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        BasePage.setWebDriver(driver);
        driver.get("https://demo.prestashop.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame("framelive");


        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingMassage")));
        } catch (Exception e){
            e.printStackTrace();
        }



    }







    @AfterMethod
    public void quit() {
        if (BasePage.getWebDriver() != null) {
            BasePage.getWebDriver().quit();
        }
    }
}


