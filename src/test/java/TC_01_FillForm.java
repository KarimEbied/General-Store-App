import Pages.P01_FormPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_FillForm extends BaseTest {
    private final String name = DataUtils.getJsonData("validLogin", "name");
    private final String country = DataUtils.getJsonData("validLogin", "country");


    @Test
    public void FillForm(){
        Assert.assertEquals(new P01_FormPage(driver)
                .fillForm(name,country)
                .VerifyLandingOnProductsPage(),"Products");

    }
}
