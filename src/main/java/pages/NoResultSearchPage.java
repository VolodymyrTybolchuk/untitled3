package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NoResultSearchPage extends BasePage {
    @FindBy(xpath = "//div[@data-cel-widget='search_result_0']")
    private WebElement noResultMessage;
    @FindBy(xpath = "//span[contains(text(),'Try checking your spelling or use more general terms')]")
    private WebElement resultMessageIfInputMoreThanMaxPriceAvailable;

    public NoResultSearchPage(WebDriver driver) {
        super(driver);
    }

//    public void checkVisibilityOfNoResultMessage() {
//        noResultMessage.isDisplayed();
//    }

    public String getConfirmationOfNoResultMessage() {
        String textResult = noResultMessage.getText();
            return textResult;

    }

    public String getResultMessageIfInputMoreThanMaxPriceAvailable() {
        String resultMessage = resultMessageIfInputMoreThanMaxPriceAvailable.getText();
        return resultMessage;
    }
}
