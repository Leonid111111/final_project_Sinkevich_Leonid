package pages;

import components.Footer;
import components.TopMenu;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
public class MainPage extends BasePage {
    private Footer footer;
    private TopMenu topMenu;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
        footer = new Footer(getDriver());
    }

    @FindBy(xpath = "//i[@class='material-icons']")
    private WebElement tableIcon;

    @FindBy(xpath = "//span[@class='hide-header']")
    private WebElement hideHider;




    public MainPage tableIconClick(){
        tableIcon.click();
        return this;
    }

    public MainPage hideHiderClick(){
        tableIcon.click();
        return this;
    }

}
    



