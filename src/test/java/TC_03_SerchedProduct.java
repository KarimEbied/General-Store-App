import Pages.P01_FormPage;
import Pages.P02_ProductsPage;
import Pages.P03_CartPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03_SerchedProduct extends BaseTest {
    private final String name = DataUtils.getJsonData("validLogin", "name");
    private final String country = DataUtils.getJsonData("validLogin", "country");
    private final String product = DataUtils.getJsonData("validLogin", "product");


    @Test
    public void SearchedProduct(){
        P02_ProductsPage productsPage = new P02_ProductsPage(driver);

        Assert.assertEquals(new P01_FormPage(driver)
                .fillForm(name,country)
                .VerifyLandingOnProductsPage(),"Products");
        Assert.assertEquals(productsPage
                .SearchProduct(product),"1");

        Assert.assertEquals(productsPage.NavigateToCartPage().VerifySearchedProductVisibleInCartPage(),"Jordan 6 Rings");
        new P03_CartPage(driver).Checkout();

    }
}
