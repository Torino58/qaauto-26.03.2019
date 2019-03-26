package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsSecondPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@target= '_top']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='srg']/div")
    public
    List<WebElement> searchResultElements;

    public SearchResultsSecondPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().contains("https://www.google.com/search")
                && driver.getTitle().contains("Selenium");
    }

    public int getSearchResultsCount() {
        return searchResultElements.size();
    }

    public List<String> getSearchResultsList() {
        List<String> searchResultStringsList = new ArrayList<String>();
        for (WebElement searchResultElement : searchResultElements) {
            ((JavascriptExecutor) driver).
                    executeScript("arguments[0].scrollIntoView(true);", searchResultElement);

            String searchResultString = searchResultElement.getText();
            searchResultStringsList.add(searchResultString);
        }
        return searchResultStringsList;
    }

}
