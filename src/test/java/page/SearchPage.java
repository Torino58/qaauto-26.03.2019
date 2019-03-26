package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@target= '_top']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@name='q']")
    private  WebElement searchResult;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return signInButton.isDisplayed()
                //&& driver.getCurrentUrl().contains("https://www.google.com/")
                && driver.getTitle().contains("Google");
    }

    public SearchResultsPage searchWord(String searchTerm) {
        searchResult.sendKeys(searchTerm);
        searchResult.sendKeys(Keys.ENTER);

        return new SearchResultsPage(driver);
    }
}
