import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;

public class RegistrationWithValidDate extends BaseTest {


    @Test
    public void registrationWithValidDate() {


        MainPage mainPage = new MainPage();
        RegistrationPage registrationPage = new RegistrationPage();

        String actualResult = registrationPage.firstName + " " + registrationPage.lastName;

        String nameNewUser = mainPage.signInClick()
                .createdNewAccountUsedClick()
                .genderCheckBoxNewUserClick()
                .firstNameFieldNewUserDataEntry(registrationPage.firstName)
                .lastNameFieldNewUserDataEntry(registrationPage.lastName)
                .eMailFieldNewUserDataEntry(registrationPage.eMail)
                .passwordNewUserFieldClick(registrationPage.password)
                .birthdateFieldNewUserDataEntry("10/10/1990").
                iAgreePrivacyPolicyCheckBoxNewUserClick()
                .customerDataPrivacyCheckBoxNewUserClick()
                .saveButtonNewUserClick()
                .appearCurrentUserNameNearCartButtonCheck();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualResult)
                .as("The username of the created user does not match expectations")
                .isEqualTo(nameNewUser);
        softAssertions.assertAll();
        ;


    }
}
