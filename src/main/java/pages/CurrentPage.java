package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrentPage extends BasePage {
    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    private WebElement homeButton;

    public CurrentPage(WebDriver driver) {
        super(driver);
    }

    public void homeButtonClick() {
        homeButton.click();
    }
}
