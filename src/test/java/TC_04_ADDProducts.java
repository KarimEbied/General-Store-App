import Pages.P01_FormPage;
import Pages.P02_ProductsPage;
import Pages.P03_CartPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04_ADDProducts extends BaseTest {
    private final String name = DataUtils.getJsonData("validLogin", "name");
    private final String country = DataUtils.getJsonData("validLogin", "country");


    @Test
    public void AddProducts(){
        P03_CartPage cartPage = new P03_CartPage(driver);

        Assert.assertEquals
                (new P01_FormPage(driver)
                .fillForm(name,country)
                .VerifyLandingOnProductsPage()
                        ,"Products");
        new P02_ProductsPage(driver)
                .AddProducts()
                .NavigateToCartPage();
        Assert.assertEquals(cartPage.getPrices(),cartPage.totalPrice());
        cartPage.Checkout();


    }
}
