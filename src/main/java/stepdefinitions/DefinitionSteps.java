package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    CellPhonesAndAccessoireSearchPage cellPhonesAndAccessoireSearchPage;
    SignInPage signInPage;
    LanguageSettingsPage languageSettingsPage;
    NoResultSearchPage noResultSearchPage;
    PhonePage phonePage;
    SearchPage searchPage;
    CurrentPage currentPage;
    private static final long DEFAULT_TIME = 120;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string}")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
    }

    @When("User makes search by {string}")
    public void userMakesSearchByKeyword(final String keyword) {
        homePage.sendKeysToSearchInput(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks that {string} is correct")
    public void userChecksThatSearchResultIsCorrect(final String expectedSearchResult) {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIME);
        searchPage.checkVisibilityOfSearchResult();
        assertEquals(searchPage.getSearchResult(), expectedSearchResult);
    }

    @Then("User checks that there is {string}")
    public void userChecksThatThereIsNoSearchResult(final String expectedNoSearchResult) {
        noResultSearchPage = pageFactoryManager.getNoResultSearchPage();
        noResultSearchPage.waitForPageLoadComplete(DEFAULT_TIME);
        assertTrue(noResultSearchPage.getConfirmationOfNoResultMessage().contains(expectedNoSearchResult));
    }

    @And("User clicks *all* button")
    public void userClicksAllButton() {
        homePage.clickAllButton();
        homePage.implicitWait(DEFAULT_TIME);
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
    }

    @And("User choose *electronic* class items")
    public void userChooseElectronicClassItems() {
        homePage.clickElectronicsButton();
    }

    @And("User choose *cell phones and accessories*")
    public void userChooseCellPhonesAndAccessories() {
        homePage.waitVisibilityOfElement(DEFAULT_TIME,homePage.getCellPhoneLink());
        homePage.clickCellPhonesButton();
    }

    @And("User clicks *cell phones* filter")
    public void userClicksCellPhonesFilter() {
        cellPhonesAndAccessoireSearchPage = pageFactoryManager.getCellPhonesAndAccessoireSearchPage();
        cellPhonesAndAccessoireSearchPage.waitForPageLoadComplete(DEFAULT_TIME);
        cellPhonesAndAccessoireSearchPage.clickCellPhonesLink();
    }

    @And("User clicks on the first phone")
    public void userClicksOnTheFirstPhone() {
        cellPhonesAndAccessoireSearchPage.waitForPageLoadComplete(DEFAULT_TIME);
        cellPhonesAndAccessoireSearchPage.clickOnTheFirstPhoneLink();
    }

    @And("User clicks on the *add to cart* button")
    public void userClicksOnTheAddToCartButton() {
        phonePage = pageFactoryManager.getPhonePage();
        phonePage.waitForPageLoadComplete(DEFAULT_TIME);
        phonePage.clickAddToCartButton();
    }

    @Then("User checks {string} in cart")
    public void userChecksAmountOfItemsInCart(final String expectedAmountOfItems) {
        assertEquals(homePage.getAmountOfItemsInCart(), expectedAmountOfItems);
    }

    @And("User clicks sign-in link")
    public void userClicksSignInLink() {
        homePage.waitForPageLoadComplete(DEFAULT_TIME);
        homePage.clickSignInButton();
    }

    @When("User input {string}")
    public void userInputKeyword(final String invalidInputData) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIME);
        signInPage.sendKeysToEmailInput(invalidInputData);
    }

    @Then("User checks that {string} appears")
    public void userChecksThatExpectedMessageAppears(final String expectedErrorMessage) {
        assertEquals(signInPage.getErrorMessage(), expectedErrorMessage);
    }

    @And("User clicks on the *language* button")
    public void userClicksOnTheLanguageButton() {
        phonePage = pageFactoryManager.getPhonePage();
        phonePage.waitForPageLoadComplete(DEFAULT_TIME);
        phonePage.clickChangeLanguageButton();
    }

    @And("User clicks on the *currency format change* button")
    public void userClicksOnTheCurrencyFormatChangeButton() {
        languageSettingsPage = pageFactoryManager.getLanguageSettingsPage();
        languageSettingsPage.waitForPageLoadComplete(DEFAULT_TIME);
        languageSettingsPage.clickCurrencySettingsButton();
    }

    @And("User choose Russian ruble")
    public void userChooseRussianRuble() {
        languageSettingsPage.clickRussianRuble();
    }

    @And("User clicks on the *save changes* button")
    public void userClicksOnTheSaveChangesButton() {
        languageSettingsPage.clickSaveChangesButton();
    }

    @Then("User checks {string}")
    public void userChecksExpectedValueOfPrice(final String expectedValue) {
        phonePage.waitForPageLoadComplete(DEFAULT_TIME);
        assertTrue(phonePage.getPriceValue().contains(expectedValue));
    }

    @And("User checks visibility of *currency format change* button")
    public void userChecksVisibilityOfCurrencyFormatChangeButton() {
        languageSettingsPage.visibilityOfCurrencySettingsButton();
    }

    @And("User checks visibility of *electronic* class items")
    public void userChecksVisibilityOfElectronicClassItems() {
        homePage.visibilityOfElectronicsButton();
    }

    @And("User checks visibility of *cell phones and accessories*")
    public void userChecksVisibilityOfCellPhonesAndAccessories() {
        homePage.visibilityOfCellPhonesButton();
        assertTrue(homePage.visibilityOfCellPhonesButton());
    }

    @Then("User checks amount of {string}")
    public void userChecksAmountOfExpectedAmountOfElements(final String expectedAmount) {
        cellPhonesAndAccessoireSearchPage.implicitWait(DEFAULT_TIME);
        String elementsAmount = String.valueOf(cellPhonesAndAccessoireSearchPage.getListOfElementsDeclaredOnThePage().size());
        assertEquals(elementsAmount, expectedAmount);
    }

    @When("User enters {string} to min and max price filter")
    public void userEntersKeywordToMinAndMaxPriceFilter(final String keyword) {
        cellPhonesAndAccessoireSearchPage = pageFactoryManager.getCellPhonesAndAccessoireSearchPage();
        cellPhonesAndAccessoireSearchPage.waitForPageLoadComplete(DEFAULT_TIME);
        cellPhonesAndAccessoireSearchPage.sendKeysToFilters(keyword);
    }

    @Then("User checks correct {string}")
    public void userChecksCorrectExpectedAmountOfItems(final String expectedAmountOfItemAfterFilter) {
        String amountOfItemAfterFilter = String.valueOf(cellPhonesAndAccessoireSearchPage.getListOfElementsDeclaredOnThePage().size());
        assertEquals(amountOfItemAfterFilter, expectedAmountOfItemAfterFilter);
    }

    @And("User clicks *go* button")
    public void userClicksGoButton() {
        cellPhonesAndAccessoireSearchPage.clickGoButton();
    }

    @Then("User checks appeared {string}")
    public void userChecksAppearedExpectedMessage(final String expectedResultMessage) {
        noResultSearchPage = pageFactoryManager.getNoResultSearchPage();
        noResultSearchPage.waitForPageLoadComplete(DEFAULT_TIME);
        assertEquals(noResultSearchPage.getResultMessageIfInputMoreThanMaxPriceAvailable(), expectedResultMessage);
    }

    @When("User enters more than max price {string} to min and max price filter")
    public void userEntersMoreThanMaxPriceKeywordToMinAndMaxPriceFilter(final String keyword) {
        cellPhonesAndAccessoireSearchPage = pageFactoryManager.getCellPhonesAndAccessoireSearchPage();
        cellPhonesAndAccessoireSearchPage.waitForPageLoadComplete(DEFAULT_TIME);
        cellPhonesAndAccessoireSearchPage.sendKeysToFilters(keyword);
    }

    @Then("User checks that there is no price more then {string}")
    public void userChecksThatThereIsNoPriceMoreThenBoundOfPrice(final String boundaryPrice) {
        List<WebElement> listOfPrices = cellPhonesAndAccessoireSearchPage.getListOfPrices();
        int numberOfBoundaryPrice = Integer.parseInt(boundaryPrice);
        assertTrue(listOfPrices.stream().allMatch(x -> Integer.parseInt(x.getText()) < numberOfBoundaryPrice));
    }

    @And("User clicks on filter that shows items with price less then twentyfive dollars")
    public void userClicksOnFilterThatShowsItemsWithPriceLessThenTwentyFiveDollars() {
        cellPhonesAndAccessoireSearchPage = pageFactoryManager.getCellPhonesAndAccessoireSearchPage();
        cellPhonesAndAccessoireSearchPage.waitForPageLoadComplete(DEFAULT_TIME);
        cellPhonesAndAccessoireSearchPage.clickUnder25DollarsButton();
    }

    @When("User clicks *home* button")
    public void userClicksHomeButton() {
        currentPage = pageFactoryManager.getCurrentPage();
        currentPage.waitForPageLoadComplete(DEFAULT_TIME);
        currentPage.homeButtonClick();
    }

    @Then("User checks that page is {string}")
    public void userChecksThatPageIsExpectedHomePage(final String expectedHomePage) {
        assertEquals(driver.getCurrentUrl(), expectedHomePage);
    }

    @And("User clicks on the *language settings* button")
    public void userClicksOnTheLanguageSettingsButton() {
        homePage.clickChangeLanguageButton();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
