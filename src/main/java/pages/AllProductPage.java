package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.support.PageFactory;

@Log4j
public class AllProductPage extends BasePage {

    MainPage mainPage = new MainPage();

    public AllProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public AllProductPage allProductButtonClick() {
        log.info("Click on the link all products");
        mainPage.getAllProductButton();
        return this;
    }


}
