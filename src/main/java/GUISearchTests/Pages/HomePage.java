package GUISearchTests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private static final String url = "https://duckduckgo.com/";
    private static final By searchBar = By.id("searchbox_input");

   public HomePage(WebDriver driver)
   {
       this.driver = driver;
   }

   public void openHomePage()
   {
       driver.navigate().to(url);
   }

   public SearchResultsPage searchFor(String searchText)
   {
       driver.findElement(searchBar).sendKeys(searchText, Keys.ENTER);
       return new SearchResultsPage(driver);
   }

}
