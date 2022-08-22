package androidSetUp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Capabilities {

    protected AppiumDriver<MobileElement> driver;
    private AppiumDriverLocalService service;

    //This Method is sets the Desired Capabilities, sent by Appium clients to the server when a new automation session is requested.
    public void preparation() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11.0");
        desiredCapabilities.setCapability("deviceName", "Pixel 4 API 30");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", "/Users/jenswindmuller/Downloads/automation-challenge-master/android/app-debug.apk");
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        String service_url = service.getUrl().toString();
        driver = new AndroidDriver<MobileElement>(new URL(service_url), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //This Method stops the Appium server
    public void stopServer() {
        service.stop();
    }
}
