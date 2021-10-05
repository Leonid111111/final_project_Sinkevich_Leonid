import lombok.extern.log4j.Log4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;

@Log4j
public class RegistrationWithInvalidData extends BaseTest {


    @Test
    public void registrationWithInvalidData() {


        MainPage mainPage = new MainPage();
        RegistrationPage registrationPage = new RegistrationPage();

        String expectedPopUpText = "Invalid name";
        String expectedColorBoarder = "rgba(255, 76, 76, 1)";

        String actualPopUpText = mainPage.signInClick()
                .createdNewAccountUsedClick()
                .genderCheckBoxNewUserClick()
                .firstNameFieldNewUserDataEntry("James8")
                .lastNameFieldNewUserDataEntry(registrationPage.lastName)
                .eMailFieldNewUserDataEntry(registrationPage.eMail)
                .passwordNewUserFieldClick(registrationPage.password)
                .birthdateFieldNewUserDataEntry("10/10/1990").
                iAgreePrivacyPolicyCheckBoxNewUserClick()
                .customerDataPrivacyCheckBoxNewUserClick()
                .saveButtonNewUserClick()
                .popUpWithTextGetText();

        String actualColorHighlighter = registrationPage.highlighterGetValue();

        log.info(actualColorHighlighter);
        log.info(actualPopUpText);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualPopUpText)
                .as("The expected inscription does not match the actual")
                .isEqualTo(expectedPopUpText);

        softAssertions.assertThat(actualColorHighlighter)
                .as("The expected color does not match the actual")
                .isEqualTo(expectedColorBoarder);
        softAssertions.assertAll();

    }


}
