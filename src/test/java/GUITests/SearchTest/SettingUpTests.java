package GUITests.SearchTest;

import GUISearchTests.Pages.HomePage;
import GUISearchTests.Pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SettingUpTests {
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);

    }

    @AfterMethod
    public void endSession(){
        driver.quit();
    }
}
