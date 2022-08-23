package manager;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;

// when wanting to create a new PageObject please follow the syntax of homePage below
public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
}
