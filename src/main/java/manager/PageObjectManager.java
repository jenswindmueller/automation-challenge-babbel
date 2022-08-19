package manager;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.TestPage;

public class PageObjectManager {
    private WebDriver driver;
    private TestPage testPage;
    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    public TestPage getTestPage(){
        return (testPage == null) ? testPage = new TestPage(driver) : testPage;
    }
    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
}
