package pages;

import components.Footer;
import components.Product;
import components.TopMenu;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

@Log4j
@Getter
public class MainPage extends BasePage {
    Actions actions = new Actions(getDriver());
    private Footer footer;
    private TopMenu topMenu;

    WebDriverWait wait = new WebDriverWait(getDriver(), 5);

    @FindBy(xpath = "//i[@class='material-icons']")
    private WebElement tableIcon;

    @FindBy(xpath = "//span[@class='hide-header']")
    private WebElement hideHider;

    @FindBy(xpath = "//div[@class='product']")
    private List<WebElement> containers;

    @FindBy(xpath = "//a[@class='all-product-link float-xs-left float-md-right h4']")
    private WebElement allProductButton;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
        footer = new Footer(getDriver());
        topMenu = new TopMenu(getDriver());
    }

    public LoginPage signInClick() {
        log.info("Click on the Sign In button");
        topMenu.getSignIn().click();
        return new LoginPage();
    }

    public OnSalePage priceDropLinkClick() {

        footer.getPriceDropLink().click();
        log.info("Click on Prices drop link");
        return new OnSalePage();
    }

    public MainPage hoverMouseOverClothesButton() {
        log.info("Hovering over the Clothing button");
        actions.moveToElement(topMenu.getClothesButton()).build().perform();
        return this;
    }

    public MainPage hoverMouseOverAccessoriesButton() {
        log.info("Hovering over the Accessories button");
        actions.moveToElement(topMenu.getAccessoriesButton()).build().perform();
        return this;
    }

    public MainPage hoverMouseOverArtButton() {
        log.info("Hovering over the Art button");
        actions.moveToElement(topMenu.getArtButton()).build().perform();
        return this;
    }

    public List<String> subMenuClothesButtonGetText() {
        log.info("Hover the mouse cursor over the Clothes button");
        List<String> subMenuClothes = new ArrayList<>();
        for (WebElement subClothes : topMenu.getSubMenuClothesButton()) {
            subMenuClothes.add(subClothes.getText());

        }
        return subMenuClothes;
    }

    public List<String> subMenuAccessoriesButtonGetText() {
        log.info("Hover the mouse cursor over the Accessories button");
        List<String> subMenuAccessories = new ArrayList<>();
        for (WebElement subAccessories : topMenu.getSubMenuAccessoriesButton()) {
            subMenuAccessories.add(subAccessories.getText());
        }
        return subMenuAccessories;
    }

    public List<String> subMenuArtButtonGetText() {
        log.info("Hover the mouse cursor over the Art button");
        List<String> subMenuArt = new ArrayList<>();
        for (WebElement subArt : topMenu.getSubMenuArtButton()) {
            subMenuArt.add(subArt.getText());
        }
        return subMenuArt;
    }

    public List<String> allLanguageListGet() {
        log.info("foreach has started to retrieve a list of languages");
        List<String> language = new ArrayList<>();
        for (WebElement langList : topMenu.getAllLanguageList()) {
            language.add(langList.getAttribute("text"));
        }
        return language;
    }

    public List<Product> mostPopularProductAtList() {
        log.info("list of popular products with characteristics");
        List<Product> popProdList = new ArrayList<>();
        for (WebElement container : containers) {
            popProdList.add(new Product(container));
            log.info(popProdList);
        }
        return popProdList;
    }


}


