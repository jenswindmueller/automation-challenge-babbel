package StepDefinitionsWeb;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageObjectManager;
import manager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class DeeplSteps {

    WebDriver driver;
    HomePage homePage;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;

    @Before("@web") // gets executed before any test scenario in the web
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
        }
        assertThat(homePage.getSourceLanguage()).as("The Translator did not detect the correct language").isEqualTo(language);
    }

    @Then("User verifies amount of languages are as stated")
    public void userVerifiesAmountOfLanguagesAreAsStated() {
        assertThat(homePage.getAdvertisedCountOfLanguages())
                .as("The amount of languages deepl claims to have does not seem to be right")
                .isEqualTo(homePage.getSelectableLanguageCount());
    }

    @After("@web")  // gets executed after any test scenario in the web
    public void closeDriver() {
        webDriverManager.closeDriver();
    }
}
