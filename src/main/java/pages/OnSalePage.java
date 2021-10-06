package pages;

import components.Footer;
import components.Product;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


@Getter
@Log4j
public class OnSalePage extends BasePage {

    Footer footer;
    Product product;
    MainPage mainPage = new MainPage();

    public OnSalePage() {
        PageFactory.initElements(getDriver(), this);
        footer = new Footer(getDriver());
    }
    @FindBy(xpath = "//button[@class='btn-unstyle select-title']")
    private WebElement sortDropDownList;

    @FindBy(xpath = "(//a[@class='select-list js-search-link'])[2]")
    private WebElement sortNameAtoZ;

    @FindBy(xpath = "(//a[@class='select-list js-search-link'])[3]")
    private WebElement sortNameZtoA;

    @FindBy(xpath = "(//a[@class='select-list js-search-link'])[4]")
    private WebElement sortPriceLowToHigh;

    @FindBy(xpath = "(//a[@class='select-list js-search-link'])[5]")
    private WebElement sortPriceHighToLow;

    public List<Product> priceDropCheck() {
        log.info("list of drop sale");
        List<Product> priceDrop = new ArrayList<>();
        for (WebElement container : mainPage.getContainers()) {
            priceDrop.add(new Product(container));
        }
        return priceDrop;
    }

}
