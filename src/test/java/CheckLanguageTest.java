import lombok.extern.log4j.Log4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

@Log4j
public class CheckLanguageTest extends BaseTest {

    @Test
    public void checkLanguage() {

        MainPage mainPage = new MainPage();
        List<String> allLanguageFromSite = mainPage.allLanguageListGet();
        System.out.println(allLanguageFromSite);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(allLanguageFromSite)
                .as("")
                .hasSize(44);

        softAssertions.assertThat(allLanguageFromSite)
                .as("")
                .contains("Українська");

        softAssertions.assertAll();
    }

}
