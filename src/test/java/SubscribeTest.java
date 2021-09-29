import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class SubscribeTest extends BaseTest {


    @Test
    public void checkOfSubscribeModule() {


        String ExpectedTextNearTheEmailField = "Get our latest news and special sales";
        String ExpectedTextUnderEmailField = "You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.";
        String ExpectedTextSubscribeButton = "Subscribe";
        String ExpectedAllCharacterInUpperCase = "uppercase";

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
                .isEqualTo(ExpectedTextNearTheEmailField);

        softAssertions.assertThat(actualTextUnderEmailField)
                .as("The text displayed on the site not is expected")
                .isEqualTo(ExpectedTextUnderEmailField);

        softAssertions.assertThat(actualAllCharacterInUpperCase)
                .as("The inscription on the button signature is written not in UpperCase")
                .isEqualTo(ExpectedAllCharacterInUpperCase);

        softAssertions.assertThat(actualTextSubscribeButton)
                        .as("The text displayed on the button not is expected")
                .isEqualTo(ExpectedTextSubscribeButton);

        softAssertions.assertAll();


    }

}
