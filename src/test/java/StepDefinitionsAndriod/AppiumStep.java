package StepDefinitionsAndriod;

import andriodSetUp.Capabilities;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import java.net.MalformedURLException;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class AppiumStep extends Capabilities {

    @Before("@appium")
    public void setUp() throws MalformedURLException {
        preparation();
    }

    @Given("User Logs in to QA App with {string} and {string}")
    public void userLogsInToQAAppWithAnd(String emailAddress, String password) {
        log.info("User is logging in with given user credentials");
        MobileElement emailField = driver.findElementById("com.github.fgoncalves.qa:id/email");
        MobileElement passwordField = driver.findElementById("com.github.fgoncalves.qa:id/password");
        MobileElement signInButton = driver.findElementById("com.github.fgoncalves.qa:id/email_sign_in_button");
        emailField.sendKeys(emailAddress);
        passwordField.sendKeys(password);
        signInButton.click();
    }

    @When("User is logged in successfully") //Finish this method tonight
    public void userIsLoggedInSuccessfully() {
        boolean loginSuccess = true;
        try {
            MobileElement loginProgress = driver.findElementById("com.github.fgoncalves.qa:id/login_progress");
        } catch (NoSuchElementException e) {
           loginSuccess = false;
        }
        assertThat(loginSuccess).as("Login failed please check, for some reason you are still on the login page").isEqualTo(true);
        try {
            Thread.sleep(5000); //using Thread.sleep to give the app time to load 
        } catch(InterruptedException e) {
            log.info("got interrupted!");
        }
    }

    @And("User clicks On CLick Me button below the Image")
    public void userClicksOnCLickMeButtonBelowTheImage() {
        MobileElement outOfHomeBtn = driver.findElementById("com.github.fgoncalves.qa:id/OutOfHomeBtn");
        outOfHomeBtn.click();
    }

    @And("User clicks On Click me button below the Welcome text")
    public void userClicksOnClickMeButtonBelowTheWelcomeText() {
        MobileElement outOfHomeBtn = driver.findElementById("com.github.fgoncalves.qa:id/clickMeBtn");
        outOfHomeBtn.click();
        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            log.info("got interrupted!");
        }
    }

    @Then("User checks if a Text appears")
    public void userChecksIfATextAppears() {
        boolean captured = true;
        try {
            MobileElement captureMe = driver.findElementByXPath("//android.widget.Toast");
            log.info(captureMe.getText());
        } catch (NoSuchElementException e) {
            captured = false;
        }
        assertThat(captured).as("Nothing happened").isEqualTo(true);
    }

    @After("@appium")
    public void closeUp() {
        stopServer();
    }
}
