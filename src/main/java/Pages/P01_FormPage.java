package Pages;

import Utilities.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class P01_FormPage extends AndroidActions {
    AndroidDriver driver;

    public P01_FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By Name = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private By CountryList = AppiumBy.id("android:id/text1");
    private By Egypt = AppiumBy.androidUIAutomator("new UiSelector().text(\"Egypt\")");
    private By ShopBTN = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
    private By ErrorMSG = AppiumBy.xpath("(//android.widget.Toast)[1]");

    public P02_ProductsPage fillForm(String name, String Country) {
        SendData(driver, Name, name);
        driver.hideKeyboard();
        ClickingOnElement(driver, CountryList);
        scrollToText(Country);
        ClickingOnElement(driver, Egypt);
        ClickingOnElement(driver, ShopBTN);
        return new P02_ProductsPage(driver);
    }

    public String InValidLogin() {
        ClickingOnElement(driver, ShopBTN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return ErrorMSG.findElement(driver).getAttribute("name");
    }
}


