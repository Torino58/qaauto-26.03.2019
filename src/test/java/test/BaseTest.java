package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.SearchPage;

public class BaseTest {

    private WebDriver driver;
    SearchPage searchPage;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SkillUP_Student\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        searchPage = new SearchPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}

