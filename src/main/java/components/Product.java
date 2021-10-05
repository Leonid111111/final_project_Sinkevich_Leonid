package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public class Product {

    private WebElement name;
    private String nameAsString;
    private WebElement pictures;
    private String regularPrice;
    private double regularPriceAsDouble;
    private String currentPrice;
    private double currentPriceAsDouble;
    private String discountPercent;
    private double doubleDiscount;


    public Product(WebElement container) {
        this.name = container.findElement(By.xpath(".//*[@class='h3 product-title']"));
        this.nameAsString = name.getText();
        this.pictures = container.findElement(By.xpath(".//a[@class='thumbnail product-thumbnail']//img"));
        if (container.findElements(By.xpath(".//span[@class='regular-price']")).size() > 0) {
            this.regularPrice = container.findElement(By.xpath(".//span[@class='regular-price']")).getText();
            this.regularPriceAsDouble = Double.parseDouble(regularPrice.replace("€", ""));
        }
        this.currentPrice = container.findElement(By.xpath(".//span[@class='price']")).getText();
        this.currentPriceAsDouble = Double.parseDouble(currentPrice.replace("€", ""));
        if (container.findElements(By.xpath(".//li[@class='product-flag discount']")).size() > 0) {
            this.discountPercent = container.findElement(By.xpath(".//li[@class='product-flag discount']"))
                    .getText().replace("-", "").replace("%", "");
            doubleDiscount = Double.parseDouble(discountPercent);

        } else {
            this.discountPercent = null;
        }

    }
}
