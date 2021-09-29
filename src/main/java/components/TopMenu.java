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

    @FindBy(xpath = "//ul[@aria-labelledby='language-selector-label']")
    private List<WebElement> allLanguageList;

    @FindBy(xpath = "//span[@class='hidden-sm-down']")
    private WebElement signIn;


    public TopMenu appearCurrentUserNameNearCartButtonCheck() {
        signIn.getText();
        return this;
    }

    public TopMenu dropdownLanguageMenuClick() {
        dropdownLanguageMenu.click();
        return this;
    }

    public List<String> allLanguageListGet() {
        List<String> language = new ArrayList<>();
        for (WebElement langList : allLanguageList) {
            language.add(langList.getAttribute("text"));
        }
        return language;
    }

}