package StepDefinitionsWeb;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import manager.PageObjectManager;
import manager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class StepDefinitionsTemplate {

    WebDriver driver;
    HomePage homePage;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;


    @Before("@web")
    public void openBrowser() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
    }

    @Given("User visits deepl translator")
    public void userVisitsDeeplTranslator() {
        homePage = pageObjectManager.getHomePage();
        homePage.navigateTo_HomePage();
        homePage.clickAcceptAllCookies();
    }

    @When("User views languages to translate from")
    public void userViewsLanguagesToTranslateFrom() {
        homePage.selectSourceLanguage();
    }

    @And("User views languages to translate to")
    public void userViewsLanguagesToTranslateTo() {
        homePage.selectTargetLanguage();
    }

    @And("User selects {string} to translate")
    public void userSelectsToTranslate(String language) {
        homePage.searchLanguage(language);
        homePage.selectSearchResult();
    }

    @And("User enters text to be translated")
    public void userEntersTextToBeTranslated() {
        homePage.enterTextToTranslate("Ich will Babbels nächster Test Automatisierung Ingenieur werden");
    }

    @Then("User checks if {string} was auto detected")
    public void userChecksIfAutoDetectWorked(String language) {
        try {
            Thread.sleep(2000); //using Thread.sleep to give the deepl time to detect the Language
        } catch(InterruptedException e) {
            log.info("got interrupted!");
        }
        assertThat(homePage.getSourceLanguage()).as("The Translator did not detect the correct language").isEqualTo(language);
    }

    @After("@web")
    public void closeDriver() {
        webDriverManager.closeDriver();
    }
}
