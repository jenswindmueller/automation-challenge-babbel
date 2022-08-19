package StepDefinitions;


import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import pageObjects.HomePage;
import pageObjects.TestPage;



@Log4j2
public class StepDefinitionsTemplate {

    TestPage testPage;
    HomePage homePage;
    TestContext testContext;


    public StepDefinitionsTemplate(TestContext context) {
        testContext = context;
        testPage = testContext.getPageObjectManager().getTestPage();
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("Open google.com")
    public void openGoogleCom() {
        homePage.navigateTo_HomePage();
    }
    @When("Clicking on reject all button")
    public void clickingOnRejectAllButton() {
        testPage.clickRejectAll();
    }

    @When("Entering number {int} and {int}")
    public void entering_number_and(Integer first, Integer second) {
        testPage.searchKeyword(first + " + "  + second);
    }
}
