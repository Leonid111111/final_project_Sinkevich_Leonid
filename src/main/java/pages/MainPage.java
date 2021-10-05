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

import java.util.ArrayList;
import java.util.List;

@Log4j
@Getter
public class MainPage extends BasePage {
    Actions actions = new Actions(getDriver());
    private Footer footer;
    private TopMenu topMenu;
    @FindBy(xpath = "//i[@class='material-icons']")
    private WebElement tableIcon;
    @FindBy(xpath = "//span[@class='hide-header']")
    private WebElement hideHider;
    @FindBy(xpath = "//div[@class='product']")
    private List<WebElement> containers;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
        footer = new Footer(getDriver());
        topMenu = new TopMenu(getDriver());
    }

    public LoginPage signInClick() {
        topMenu.getSignIn().click();
        log.info("Click on the SignIn button");
        return new LoginPage();
    }

    public OnSalePage priceDropLinkClick() {
        footer.getPriceDropLink().click();
        return new OnSalePage();
    }

    public MainPage hoverMouseOverClothesButton() {
        actions.moveToElement(topMenu.getClothesButton()).build().perform();
        log.info("Hovering over the Clothing button");
        return this;
    }

    public MainPage hoverMouseOverAccessoriesButton() {
        actions.moveToElement(topMenu.getAccessoriesButton()).build().perform();
        log.info("Hovering over the Accessories button");
        return this;
    }

    public MainPage hoverMouseOverArtButton() {
        actions.moveToElement(topMenu.getArtButton()).build().perform();
        log.info("Hovering over the Art button");
        return this;
    }

    public List<String> subMenuClothesButtonGetText() {
        List<String> subMenuClothes = new ArrayList<>();
        for (WebElement subClothes : topMenu.getSubMenuClothesButton()) {
            subMenuClothes.add(subClothes.getText());
            log.info("Hover the mouse cursor over the Clothes button");
        }
        return subMenuClothes;
    }

    public List<String> subMenuAccessoriesButtonGetText() {
        List<String> subMenuAccessories = new ArrayList<>();
        for (WebElement subAccessories : topMenu.getSubMenuAccessoriesButton()) {
            subMenuAccessories.add(subAccessories.getText());
            log.info("Hover the mouse cursor over the Accessories button");
        }
        return subMenuAccessories;
    }

    public List<String> subMenuArtButtonGetText() {
        List<String> subMenuArt = new ArrayList<>();
        for (WebElement subArt : topMenu.getSubMenuArtButton()) {
            subMenuArt.add(subArt.getText());
            log.info("Hover the mouse cursor over the Art button");
        }
        return subMenuArt;
    }

    public List<String> allLanguageListGet() {
        List<String> language = new ArrayList<>();
        for (WebElement langList : topMenu.getAllLanguageList()) {
            language.add(langList.getAttribute("text"));
            log.info("foreach has started to retrieve a list of languages");
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


