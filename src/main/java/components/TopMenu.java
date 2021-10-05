package components;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Log4j
@Getter
public class TopMenu {
    @FindBy(xpath = "//span[@class='expand-more']")
    private WebElement dropdownLanguageMenu;
    @FindBy(xpath = ".//a[@data-iso-code]")
    private List<WebElement> allLanguageList;
    @FindBy(xpath = "//span[@class='hidden-sm-down']")
    private WebElement signIn;
    @FindBy(xpath = "//li[@id='category-3']")
    private WebElement clothesButton;
    @FindBy(xpath = "//li[@id='category-6']")
    private WebElement accessoriesButton;
    @FindBy(xpath = "//li[@id='category-9']")
    private WebElement artButton;
    @FindBy(xpath = "//li[@id='category-3']//li")
    private List<WebElement> subMenuClothesButton;
    @FindBy(xpath = "//li[@id='category-6']//li")
    private List<WebElement> subMenuAccessoriesButton;
    @FindBy(xpath = "//li[@id='category-9']//li")
    private List<WebElement> subMenuArtButton;

    public TopMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}