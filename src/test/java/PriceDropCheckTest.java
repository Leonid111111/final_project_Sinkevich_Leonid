import components.Product;
import lombok.extern.log4j.Log4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OnSalePage;
import java.math.BigDecimal;
import java.util.List;

@Log4j
public class PriceDropCheckTest extends BaseTest {

    @Test
    public void priceDropCheck() {
        MainPage mainPage = new MainPage();
        OnSalePage onSalePage = new OnSalePage();
        SoftAssertions softAssertions = new SoftAssertions();
        List<Product> listDropPrice = mainPage.priceDropLinkClick().priceDropCheck();
        for (Product product : listDropPrice) {
            softAssertions.assertThat(product.getCurrentPriceAsDouble())
                    .as("Not all goods have a Current Price ")
                    .isNotNull();
        }
        for (Product product : listDropPrice) {
            softAssertions.assertThat(product.getRegularPriceAsDouble())
                    .as("Not all goods have a Old Price ")
                    .isNotNull();
        }

        for (Product product : listDropPrice) {
            BigDecimal oneHundred = new BigDecimal("100");
            BigDecimal discount = new BigDecimal(String.valueOf(product.getCurrentPriceAsDouble()));
            BigDecimal regPrice = new BigDecimal(String.valueOf(product.getRegularPriceAsDouble()));

            BigDecimal expectedValue = oneHundred.subtract(discount.divide(regPrice, 2).multiply(oneHundred));

            softAssertions.assertThat(product.getDoubleDiscount())
                    .as("Not all goods have a Old Price ")
                    .isEqualTo(expectedValue.doubleValue());
            softAssertions.assertAll();
        }
    }

}
