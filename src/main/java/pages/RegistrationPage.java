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
        log.info("Choose gender in checkbox");
        genderCheckBoxNewUser.click();
        log.info("Click on the gender checkBox, Mr.");
        return this;
    }

    public RegistrationPage firstNameFieldNewUserDataEntry(String firstName) {
        log.info("Enter the first name of the new user");
        firstNameFieldNewUser.sendKeys(firstName);
        return this;
    }

    public RegistrationPage lastNameFieldNewUserDataEntry(String lastName) {
        log.info("Enter the last name of the new user");
        lastNameFieldNewUser.sendKeys(lastName);
         return this;
    }

    public RegistrationPage eMailFieldNewUserDataEntry(String eMail) {
        log.info("Enter the eMail of the new user");
        eMailFieldNewUser.sendKeys(eMail);
        return this;
    }

    public RegistrationPage passwordNewUserFieldEntry(String password) {
        log.info("Enter the password of the new user");
        passwornNewUserField.sendKeys(password);
        return this;
    }

    public RegistrationPage birthdateFieldNewUserDataEntry(String birthdate) {
        log.info("Enter the birthday of the new user");
        birthdateFieldNewUser.sendKeys(birthdate);
        return this;
    }

    public RegistrationPage customerDataPrivacyCheckBoxNewUserClick() {
        log.info("Confirm customer Data Privacy");
        customerDataPrivacyCheckBoxNewUser.click();
        return this;
    }

    public RegistrationPage iAgreePrivacyPolicyCheckBoxNewUserClick() {
        log.info("Confirm Privacy Policy Check Box");
        iAgreePrivacyPolicyCheckBoxNewUser.click();
        return this;
    }

    public RegistrationPage saveButtonNewUserClick() {
        log.info("Click on the button to create a new user");
        saveButtonNewUser.click();
        return this;
    }

    public String highlighterGetValue() {
        log.info("Highlighter frame color data get value");
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
