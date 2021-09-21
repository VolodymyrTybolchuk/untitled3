package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public CellPhonesAndAccessoireSearchPage getCellPhonesAndAccessoireSearchPage() {
        return new CellPhonesAndAccessoireSearchPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public LanguageSettingsPage getLanguageSettingsPage() {
        return new LanguageSettingsPage(driver);
    }

    public NoResultSearchPage getNoResultSearchPage() {
        return new NoResultSearchPage(driver);
    }

    public PhonePage getPhonePage() {
        return new PhonePage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }
}
