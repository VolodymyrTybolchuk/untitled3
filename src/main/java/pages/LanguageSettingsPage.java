package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageSettingsPage extends BasePage {
    @FindBy(xpath = "//span[@class='a-button-inner']//span[@id='a-autoid-0-announce']")
    private WebElement currencySettingsButton;
    @FindBy(xpath = "//a[@data-value='{\"stringVal\":\"RUB\"}']")
    private WebElement russianRuble;
    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement saveChangesButton;
    private static final long DEFAULT_TIME = 120;

    public LanguageSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCurrencySettingsButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", currencySettingsButton);
        currencySettingsButton.click();

    }

    public void clickRussianRuble() {
        russianRuble.click();
    }

    public void clickSaveChangesButton() {
        saveChangesButton.click();
    }

    public void visibilityOfCurrencySettingsButton() {
        currencySettingsButton.isDisplayed();
    }
}
