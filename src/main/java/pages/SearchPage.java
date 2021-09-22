package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    private WebElement cellPhoneResult;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void checkVisibilityOfSearchResult() {
        cellPhoneResult.isDisplayed();
    }

    public String getSearchResult() {
        String textResult = cellPhoneResult.getText();
        return textResult;
    }
}
