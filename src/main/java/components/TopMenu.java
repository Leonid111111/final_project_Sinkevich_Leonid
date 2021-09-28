package components;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TopMenu {
    public TopMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='expand-more']")
    private WebElement dropdownLanguageMenu;

    @FindBy(css = "dropdown-menu hidden-sm-down")
    private List<WebElement> allLanguageListCss;

    @FindBy(xpath = "//ul[@class='dropdown-menu']")
    public List<WebElement> allLanguageList;


    public TopMenu dropdownLanguageMenuClick() {
        dropdownLanguageMenu.click();
        return this;
    }

    public String allLanguageListGet() {
        return dropdownLanguageMenu.getCssValue("dropdown-menu");
    }
    public String qqqqqqqqqqqqq() {
        List<String> qqqq = new ArrayList<String>();
        for (WebElement e:allLanguageList) {

            qqqq.add(e.getCssValue("li"));
        }
        return qqqqqqqqqqqqq();
    }
}