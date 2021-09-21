package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class SignInPage extends BasePage{
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//h4")
    private WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }
    public void sendKeysToEmailInput(final String keyword){
        emailInput.sendKeys(keyword,ENTER);
    }
public String getErrorMessage(){
        String textOfMessage=errorMessage.getText();
        return textOfMessage;
}
}
