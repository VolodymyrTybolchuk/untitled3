package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonePage extends BasePage{
@FindBy(xpath = "//input[@id='add-to-cart-button']")
private WebElement addToCartButton;

@FindBy(xpath = "//span[@class='icp-nav-link-inner']")
private WebElement changeLanguageButton;
@FindBy(xpath = "//span[@id='price_inside_buybox']")
private WebElement priceInsideBuyBox;

    public PhonePage(WebDriver driver) {
        super(driver);
    }

public void clickAddToCartButton(){
        addToCartButton.click();
}
public void clickChangeLanguageButton(){
        changeLanguageButton.click();
}
public String getPriceValue(){
        String priceValue= priceInsideBuyBox.getText();
        return priceValue;
}
}
