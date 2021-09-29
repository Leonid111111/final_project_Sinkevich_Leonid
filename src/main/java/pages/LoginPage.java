package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='email']")
    private WebElement eMailFieldForRegisteredUser;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordFieldForRegisteredUser;

    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElement signInButtonForRegisteredUser;

    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    private WebElement createdNewAccountUsed;
}
