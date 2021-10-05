package pages;

import com.github.javafaker.Faker;
import components.TopMenu;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;

@Getter
@Log4j
public class RegistrationPage extends BasePage {

    TopMenu topMenu;
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String eMail = faker.internet().emailAddress();
    public String password = faker.internet().password();
    public String birthdate = faker.date().birthday().toString();
    public Date birthdate1 = faker.date().birthday();
    @FindBy(xpath = "//input[@name='id_gender']")
    private WebElement genderCheckBoxNewUser;
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameFieldNewUser;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameFieldNewUser;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement eMailFieldNewUser;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwornNewUserField;
    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdateFieldNewUser;
    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerDataPrivacyCheckBoxNewUser;
    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement iAgreePrivacyPolicyCheckBoxNewUser;
    @FindBy(xpath = "//button[@data-link-action='save-customer']")
    private WebElement saveButtonNewUser;
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement highlighterColor;
    @FindBy(xpath = "//li[@class='alert alert-danger']")
    private WebElement popUpWithText;

    public RegistrationPage() {
        PageFactory.initElements(getDriver(), this);
        topMenu = new TopMenu(getDriver());
    }

    public RegistrationPage genderCheckBoxNewUserClick() {
        genderCheckBoxNewUser.click();
        log.info("Click on the gender checkBox, Mr.");
        return this;
    }

    public RegistrationPage firstNameFieldNewUserDataEntry(String firstName) {
        firstNameFieldNewUser.sendKeys(firstName);
        log.info("Fill in the field with the firstName");
        return this;
    }

    public RegistrationPage lastNameFieldNewUserDataEntry(String lastName) {
        lastNameFieldNewUser.sendKeys(lastName);
        log.info("Fill in the field with the lastName");
        return this;
    }

    public RegistrationPage eMailFieldNewUserDataEntry(String eMail) {
        eMailFieldNewUser.sendKeys(eMail);
        return this;
    }

    public RegistrationPage passwordNewUserFieldClick(String password) {
        passwornNewUserField.sendKeys(password);
        return this;
    }

    public RegistrationPage birthdateFieldNewUserDataEntry(String birthdate) {
        birthdateFieldNewUser.sendKeys(birthdate);
        return this;
    }

    public RegistrationPage customerDataPrivacyCheckBoxNewUserClick() {
        customerDataPrivacyCheckBoxNewUser.click();
        return this;
    }

    public RegistrationPage iAgreePrivacyPolicyCheckBoxNewUserClick() {
        iAgreePrivacyPolicyCheckBoxNewUser.click();
        return this;
    }

    public RegistrationPage saveButtonNewUserClick() {
        saveButtonNewUser.click();
        return this;
    }

    public String highlighterGetValue() {
        log.info("Highlighter frame color data");
        return highlighterColor.getCssValue("outline-color");
    }

    public String popUpWithTextGetText() {
        log.info("Pop-up text on login error" + popUpWithText);
        return popUpWithText.getText();
    }

    public String appearCurrentUserNameNearCartButtonCheck() {
        return topMenu.getSignIn().getText();
    }

}
