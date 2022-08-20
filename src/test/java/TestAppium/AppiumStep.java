package TestAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class AppiumStep {

    AppiumDriver<MobileElement> driver;
    @Before("@appium")
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11.0");
        desiredCapabilities.setCapability("deviceName", "Pixel 2 API 30");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", "app/build/outputs/apk/debug/app-debug.apk");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
        String sessionId = driver.getSessionId().toString();
    }

    @Given("User Logs in to QA App")
    public void userLogsInToQAApp() {
        log.info("User is logging in with given user credentials");
        MobileElement email = driver.findElementById("com.github.fgoncalves.qa:id/email");
        MobileElement password = driver.findElementById("com.github.fgoncalves.qa:id/password");
        MobileElement signInButton = driver.findElementById("com.github.fgoncalves.qa:id/email_sign_in_button");
        email.sendKeys("percival@gmail.com");
        password.sendKeys("123456");
        signInButton.click();
    }

    @When("User is logged in sucessfully") //Finish this method tonight
    public void userIsLoggedInSucessfully() {
        MobileElement loginProgress = driver.findElementById("com.github.fgoncalves.qa:id/login_progress");
        assertThat(loginProgress).as("Login seems to be not successfull").isDisplayed();
        Thread.sleep(5000);
    }
}
