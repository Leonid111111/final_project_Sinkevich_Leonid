package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private static ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

    public static ThreadLocal<WebDriver> getThreadLocalDriver() {
        return THREAD_LOCAL_DRIVER;
    }

    public static void setThreadLocalDriver(WebDriver driver) {
        THREAD_LOCAL_DRIVER.set(driver);
    }

    public static WebDriver getDriver() {
        return THREAD_LOCAL_DRIVER.get();
    }


}
