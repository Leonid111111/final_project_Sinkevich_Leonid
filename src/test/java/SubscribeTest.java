import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;


public class SubscribeTest extends BaseTest {


    @Test
    public void checkOfSubscribeModule() {


        String expectedTextNearTheEmailField = "Get our latest news and special sales";
        String expectedTextUnderEmailField = "You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.";
        String expectedTextSubscribeButton = "Subscribe";
        String expectedAllCharacterInUpperCase = "uppercase";

        MainPage mainPage = new MainPage();


        String actualTextNearTheEmailField = mainPage.getFooter()
                .latestNewsAndSpecialSalesGetText();


        String actualTextUnderEmailField = mainPage.getFooter()
                .youMayUnsubscribeAtAnyMomentGetText();

        String actualAllCharacterInUpperCase = mainPage.getFooter()
                .subscribeButtonInUpperCase();

        String actualTextSubscribeButton = mainPage.getFooter()
                .subscribeButtonGetText();
        System.out.println(actualTextSubscribeButton);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualTextNearTheEmailField)
                .as("The text displayed on the site not is expected")
                .isEqualTo(expectedTextNearTheEmailField);

        softAssertions.assertThat(actualTextUnderEmailField)
                .as("The text displayed on the site not is expected")
                .isEqualTo(expectedTextUnderEmailField);

        softAssertions.assertThat(actualAllCharacterInUpperCase)
                .as("The inscription on the button signature is written not in UpperCase")
                .isEqualTo(expectedAllCharacterInUpperCase);

        softAssertions.assertThat(actualTextSubscribeButton)
                .as("The text displayed on the button not is expected")
                .isEqualTo(expectedTextSubscribeButton);

        softAssertions.assertAll();


    }

}
