import Pages.P01_FormPage;
import Utilities.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_InVaildLogin extends BaseTest {

    @Test
    public void FillForm(){
        Assert.assertEquals(new P01_FormPage(driver)
                .InValidLogin(),"Please enter your name");
    }
}
