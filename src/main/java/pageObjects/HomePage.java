package pageObjects;

import manager.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage {
    WebDriver driver;
//  locating web elements
    @FindBy(css = ".lmt__language_select--source > .lmt__language_select__active")
    private WebElement selectSourceLanguageBtn;

    @FindBy(css = ".lmt__language_select--target > .lmt__language_select__active")
    private WebElement selectTargetLanguageBtn;

    @FindBy(css = "input.flex-1.focus-visible-disabled")
    private WebElement searchFieldLanguage;

    @FindBy(css = "button.flex.gap-2.items-center")
    private WebElement searchResult;

    @FindBy(css = ".lmt__source_textarea")
    private WebElement translateTextField;

    @FindBy(css = ".D5aOJc.vJwDU")
    private WebElement translatedText;

    @FindBy(css = ".dl_cookieBanner--buttonAll")
    private WebElement acceptAllCookies;

    @FindBy(css = ".lmt__language_select__active__title > strong")
    private WebElement pickedSourceLanguage;

    @FindBy(css = ".lmt__language_select_column > button")
    private List<WebElement> selectableLanguages;

    @FindBy(css = "#tabTranslateText > div > div > .textLower--kjeBE")
    private WebElement numberOfChoices;

    public HomePage(WebDriver driver){
//      this method initializes web elements which are defined above
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo_HomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void selectSourceLanguage() {selectSourceLanguageBtn.click();
    }

    public void selectTargetLanguage() {
        selectTargetLanguageBtn.click();
    }

    public void searchLanguage(String language) {
        searchFieldLanguage.sendKeys(language);
    }

    public void selectSearchResult() {
        searchResult.click();
    }

    public void enterTextToTranslate(String text) {
        translateTextField.sendKeys(text);
    }

    public void clickAcceptAllCookies() {
        acceptAllCookies.click();
    }

    public String getSourceLanguage() {
        return pickedSourceLanguage.getText();
    }

    public Integer getSelectableLanguageCount() {
        return selectableLanguages.size();
    }

    public Integer getAdvertisedCountOfLanguages() {
        String[] parts = numberOfChoices.getText().split(" ");
        return Integer.parseInt(parts[0]);
    }
}