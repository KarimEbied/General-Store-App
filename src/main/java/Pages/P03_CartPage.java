package Pages;

import Utilities.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class P03_CartPage  extends AndroidActions {
    AndroidDriver driver;
    public P03_CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By productName = AppiumBy.id("com.androidsample.generalstore:id/productName");
    private By checkBox = AppiumBy.className("android.widget.CheckBox");
    private By PurchaseBtn = AppiumBy.id("com.androidsample.generalstore:id/btnProceed");
    private By FproductPrice = AppiumBy.androidUIAutomator("new UiSelector().text(\"$160.97\")");
    private By SproductPrice = AppiumBy.androidUIAutomator("new UiSelector().text(\"$120.0\")");
    private By TotalPrice = AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl");

    public String VerifySearchedProductVisibleInCartPage(){
        return getText(driver,productName);
    }
    public P03_CartPage Checkout(){
        ClickingOnElement(driver,checkBox);
        ClickingOnElement(driver,PurchaseBtn);
        return this;
    }
    public float getPrices(){
        String Fcost=getText(driver,FproductPrice);
        String Scost=getText(driver,SproductPrice);
        float Fprice=Float.parseFloat(Fcost.replace("$","").trim());
        float Sprice=Float.parseFloat(Scost.replace("$","").trim());
        float sum =Fprice+Sprice;
        return sum;
    }
    public float totalPrice(){
       String total =getText(driver,TotalPrice);
       float TotalCost=Float.parseFloat(total.replace("$","").trim());
        return TotalCost;
    }



}
