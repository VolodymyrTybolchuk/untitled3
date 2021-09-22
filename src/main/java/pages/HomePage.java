package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;
    @FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
    private WebElement allButton;
    @FindBy(xpath = "//div[contains(text(),'Electronics')]")
    private WebElement electronicsButton;
    @FindBy(xpath = "//a[contains(.,'Cell Phones & Accessories')]")
    private WebElement cellPhonesButton;
    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement singInButton;
    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement countOfItemsInCart;
    @FindBy(xpath = "//span[@class='icp-nav-link-inner']")
    private WebElement changeLanguageButton;

    private static final long DEFAULT_TIME = 120;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysToSearchInput(final String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickAllButton() {
        allButton.click();
    }

    public void visibilityOfElectronicsButton() {
        electronicsButton.isDisplayed();
    }

    public void clickElectronicsButton() {
        electronicsButton.click();
    }

    public boolean visibilityOfCellPhonesButton() {
        boolean result = false;
        if (cellPhonesButton.isDisplayed()) {
            result = true;
        }
        return result;
    }

    public void clickCellPhonesButton() {
        cellPhonesButton.click();
    }

    public void clickSignInButton() {
        singInButton.click();
    }

    public String getAmountOfItemsInCart() {
        String amountOfItems = countOfItemsInCart.getText();
        return amountOfItems;
    }
    public WebElement getCellPhoneLink(){
        return cellPhonesButton;
    }

    public void clickChangeLanguageButton() {
        changeLanguageButton.click();
    }
}

