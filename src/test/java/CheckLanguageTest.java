import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class CheckLanguageTest extends BaseTest {

    @Test
    public void checkLanguage() {

        MainPage mainPage = new MainPage();
        List<String> qqq = mainPage.getTopMenu().allLanguageListGet();
        System.out.println(qqq);


        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(qqq)
                .as("")
                .hasSize(44);

        softAssertions.assertThat(qqq)
                .as("")
                .contains("Українська");

        softAssertions.assertAll();
    }

}
