import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    AppiumDriverLocalService service;
@BeforeClass
    public void Configration() throws URISyntaxException, MalformedURLException {
          service  = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Karim EA\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
        .withIPAddress("127.0.0.1").usingPort(4723).build();
    service.start();
        UiAutomator2Options options= new UiAutomator2Options();
        options.setDeviceName("KarimEA");

        options.setApp("G:\\Java Learning\\MoblieAutomation\\src\\test\\resources\\General-Store.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           //appium server --allow-insecure chromedriver_autodownload




}



@AfterClass
    public void tearDown(){
        driver.quit();
        //service.stop();
    }
}
