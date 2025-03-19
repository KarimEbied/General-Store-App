package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidActions {
    AndroidDriver driver;
    public AndroidActions(AndroidDriver driver){
        this.driver = driver;
    }


    public void scrollToText(String text){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+text+"\"));"));
    }


    public void LongPress(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                "duration",2000));
    }
    public void swipeAtion(WebElement element,String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"direction", direction,
                "percent", 0.75));
    }
    public void DragAction (WebElement element,int x, int y){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", x,
                "endY", y
        ));
    }
    // ToDo: Clicking on Element Function
    public static void ClickingOnElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    // ToDo: Sending data Function
    public static void SendData(WebDriver driver, By locator, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(data);

    }


    //ToDo: Get Text
    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

}
