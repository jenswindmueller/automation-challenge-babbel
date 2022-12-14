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
//      This method starts the web driver
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
    }

    @Given("User visits deepl translator")
    public void userVisitsDeeplTranslator() {
//      This navigates the webdriver to deepl.com
        homePage = pageObjectManager.getHomePage();
        homePage.navigateTo_HomePage();
        homePage.clickAcceptAllCookies();
    }

    @When("User views languages to translate from")
    public void userViewsLanguagesToTranslateFrom() {
//      this method clicks to view all source languages to choose from
        homePage.selectSourceLanguage();
    }

    @And("User views languages to translate to")
    public void userViewsLanguagesToTranslateTo() {
//      this method clicks to view all target languages to choose from
        homePage.selectTargetLanguage();
    }

    @And("User selects {string} to translate")
    public void userSelectsToTranslate(String language) {
//      this method adds the value of String language to the search bar and then select that result
        homePage.searchLanguage(language);
        homePage.selectSearchResult();
    }

    @And("User enters text to be translated")
    public void userEntersTextToBeTranslated() {
//      this method adds the text to be translated
        homePage.enterTextToTranslate("Ich will Babbels n??chster Test Automatisierung Ingenieur werden");
    }

    @Then("User checks if {string} was auto detected")
    public void userChecksIfAutoDetectWorked(String language) {
//      this method checks if the correct language was detected by the language detector
        try {
            Thread.sleep(2000); //using Thread.sleep to give the deepl time to detect the Language
        } catch(InterruptedException e) {
        }
        assertThat(homePage.getSourceLanguage()).as("The Translator did not detect the correct language").isEqualTo(language);
    }

    @Then("User verifies amount of languages are as stated")
    public void userVerifiesAmountOfLanguagesAreAsStated() {
//      this method checks if the amount of languages deepl states it offers is actually true
        assertThat(homePage.getAdvertisedCountOfLanguages())
                .as("The amount of languages deepl claims to have does not seem to be right")
                .isEqualTo(homePage.getSelectableLanguageCount());
    }

    @After("@web")  // gets executed after any test scenario in the web
    public void closeDriver() {
        webDriverManager.closeDriver();
    }
}
