package Pages;

import Utilities.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class P02_ProductsPage extends AndroidActions {
    AndroidDriver driver;
    public P02_ProductsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private  By Products = AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
    private  By FirstProduct = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(0)");
    private  By SecondProduct = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(1)");
    private  By AddToCartBtn = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(1)");
    private  By CartNumber = AppiumBy.id("com.androidsample.generalstore:id/counterText");
    private  By CartBTN = AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart");
    public String VerifyLandingOnProductsPage(){
        return getText(driver,Products);
    }
    public String SearchProduct(String product){
        scrollToText(product);
        ClickingOnElement(driver,AddToCartBtn);
        return getText(driver,CartNumber);
    }
    public P03_CartPage NavigateToCartPage(){
        ClickingOnElement(driver,CartBTN);
        return new P03_CartPage(driver);

    }
    public P02_ProductsPage AddProducts(){
        ClickingOnElement(driver,FirstProduct);
        ClickingOnElement(driver,SecondProduct);
        return this;
    }




}
