import lombok.extern.log4j.Log4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;


@Log4j
public class CheckCategoriesTest extends BaseTest {

    @Test()
    public void checkCategoriesOnTheSite() {
        MainPage mainPage = new MainPage();

        String expectedResultClothesMenu = "MEN," + " WOMEN";
        String expectedResultAccessories = "STATIONERY," + " HOME ACCESSORIES";
        String expectedResultArt = " ";

        String actualListSubMenuClothes = mainPage
                .hoverMouseOverClothesButton()
                .subMenuClothesButtonGetText()
                .toString();

        String actualListSubMenuAccessories = mainPage
                .hoverMouseOverAccessoriesButton()
                .subMenuAccessoriesButtonGetText()
                .toString();

        String actualListSubMenuArt = mainPage
                .hoverMouseOverArtButton()
                .subMenuArtButtonGetText()
                .toString();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualListSubMenuClothes)
                .as("Submenu items MAN and WOMEN are not displayed")
                .isEqualTo(expectedResultClothesMenu);

        softAssertions.assertThat(actualListSubMenuAccessories)
                .as("Submenu items STATIONERY and HOME ACCESSORIES are not displayed")
                .isEqualTo(expectedResultAccessories);

        softAssertions.assertThat(actualListSubMenuArt)
                .as("Submenu items ' ' are not displayed")
                .isEqualTo(expectedResultArt);

        softAssertions.assertAll();


    }


}
