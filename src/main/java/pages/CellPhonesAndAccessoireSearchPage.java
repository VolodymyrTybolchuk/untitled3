package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CellPhonesAndAccessoireSearchPage extends BasePage {
    @FindBy(xpath = "//li[@id='n/7072561011']//span[contains(text(),'Cell Phones')]")
    private WebElement cellPhonesLink;
    @FindBy(xpath = "//span[contains(text(),'Under $25')]")
    private WebElement under25DollarsFilterButton;
    @FindBy(xpath = "//div[@class='sg-col-inner']//span[@class='a-price-whole']")
    private WebElement allOfPrices;
    @FindBy(xpath = "//img[@data-image-index='1']")
    private WebElement phoneLink;
    @FindAll(@FindBy(xpath = "//div[@class='a-row a-size-small']"))
    private List<WebElement> listOfElementsDeclaredOnThePage;
    @FindBy(xpath = "//input[@id='low-price']")
    private WebElement lowPriceFilter;
    @FindBy(xpath = "//input[@id='high-price']")
    private WebElement highPriceFilter;
    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement goButton;
    @FindAll(@FindBy(xpath = "//span[@class='a-price-whole']"))
    private List<WebElement> listOfPrices;


    public CellPhonesAndAccessoireSearchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfElementsDeclaredOnThePage(){

        return listOfElementsDeclaredOnThePage;
    }
    public void clickCellPhonesLink() {
        cellPhonesLink.click();
    }

    public void clickUnder25DollarsButton() {
        under25DollarsFilterButton.click();
    }
    public void clickOnTheFirstPhoneLink() {
        phoneLink.click();
    }

    public void sendKeysToFilters(final String keyword){
        lowPriceFilter.sendKeys(keyword);
        highPriceFilter.sendKeys(keyword);
    }
    public void clickGoButton(){
        goButton.click();
    }
    public List<WebElement> getListOfPrices(){
        return listOfPrices;
    }
}
