package components;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Footer {

    public Footer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@id='block-newsletter-label']")
    private WebElement latestNewsAndSpecialSales;

    @FindBy(xpath = "(//div[@class='col-xs-12'])[2]")
    private WebElement youMayUnsubscribeAtAnyMoment;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement subscribeButtonText;




    public String latestNewsAndSpecialSalesGetText() {
        return latestNewsAndSpecialSales.getText();
    }

    public String youMayUnsubscribeAtAnyMomentGetText() {
        return youMayUnsubscribeAtAnyMoment.getText();
    }

    public String subscribeButtonInUpperCase() {
        return subscribeButton.getCssValue("text-transform");
    }

    public String subscribeButtonGetText() {
        return subscribeButtonText.getAttribute("value");
    }


}
