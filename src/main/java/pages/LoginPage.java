package pages;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j
@Getter
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement eMailFieldForRegisteredUser;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordFieldForRegisteredUser;
    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElement signInButtonForRegisteredUser;
    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    private WebElement createdNewAccountUsed;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public RegistrationPage newAccountClick() {
        log.info("Click on the new user registration button");
        createdNewAccountUsed.click();
        return new RegistrationPage();
    }
}
