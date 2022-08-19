package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage {
    public TestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "W0wltc")
    private WebElement rejectAllBtn;

    @FindBy(className = "gLFyf")
    private WebElement googleTextBox;

    public void clickRejectAll() {
        rejectAllBtn.click();
    }

    public void searchKeyword(String keyword) {
        googleTextBox.sendKeys(keyword);
    }
}
