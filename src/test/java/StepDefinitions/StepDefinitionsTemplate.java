package StepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import manager.PageObjectManager;
import manager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;



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
    @Given("User is on Home Page")
    public void user_is_on_Home_Page(){
        homePage = pageObjectManager.getHomePage();
        homePage.navigateTo_HomePage();
    }
    @When("Clicking on reject all button")
    public void clickingOnRejectAllButton() {
        pageObjectManager.getTestPage().clickRejectAll();
    }

    @When("Entering number {int} and {int}")
    public void entering_number_and(Integer first, Integer second) {
        pageObjectManager.getTestPage().searchKeyword(first + " + "  + second);
    }
}
