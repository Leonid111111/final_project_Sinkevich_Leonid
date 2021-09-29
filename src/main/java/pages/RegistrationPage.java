package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;

public class RegistrationPage extends BasePage{

    public RegistrationPage() {
        PageFactory.initElements(getDriver(), this);
    }

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

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdateFieldNewUser;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerDataPrivacyCheckBoxNewUser;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement iAgreePrivacyPolicyCheckBoxNewUser;

    @FindBy(xpath = "//button[@data-link-action='save-customer']")
    private WebElement saveButtonNewUser;

//    @FindBy(xpath = "//span[@class='hidden-sm-down']")
//    private WebElement appearCurrentUserNameNearCartButton;


    public RegistrationPage genderCheckBoxNewUserClick(){
        genderCheckBoxNewUser.click();
        return this;
    }

    public RegistrationPage firstNameFieldNewUserDataEntry(String firstName){
        firstNameFieldNewUser.sendKeys();
        return this;
    }

    public RegistrationPage lastNameFieldNewUserDataEntry(String lastName){
        lastNameFieldNewUser.sendKeys();
        return this;
    }

    public RegistrationPage eMailFieldNewUserDataEntry(String eMail){
        eMailFieldNewUser.sendKeys();
        return this;
    }

    public RegistrationPage birthdateFieldNewUserDataEntry(String birthdate){
        birthdateFieldNewUser.sendKeys();
        return this;
    }

    public RegistrationPage customerDataPrivacyCheckBoxNewUserClick(){
        customerDataPrivacyCheckBoxNewUser.click();
        return this;
    }

    public RegistrationPage iAgreePrivacyPolicyCheckBoxNewUserClick(){
        iAgreePrivacyPolicyCheckBoxNewUser.click();
        return this;
    }

    public RegistrationPage saveButtonNewUserClick(){
        saveButtonNewUser.click();
        return this;
    }
}
