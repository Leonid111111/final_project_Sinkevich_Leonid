import components.Product;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

@Log4j
@Getter
public class CheckPopularProductTest extends BaseTest {

    @Test
    public void checkPopularProduct() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        List<Product> actualPopularProduct = mainPage.mostPopularProductAtList();

        for (Product product : actualPopularProduct) {
            softAssertions.assertThat(product.getNameAsString())
                    .as("Every product not has name")
                    .isNotNull();
            log.info(product.getNameAsString());
        }
        for (Product product : actualPopularProduct) {
            softAssertions.assertThat(product.getCurrentPriceAsDouble())
                    .as("Every product not has price")
                    .isNotNull();
        }

        for (Product product1 : actualPopularProduct) {
            softAssertions.assertThat(product1.getCurrentPriceAsDouble())
                    .as("Product price is not more than 0")
                    .isGreaterThan(0);
            softAssertions.assertAll();
        }
    }
}


