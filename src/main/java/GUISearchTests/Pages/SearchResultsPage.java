package GUISearchTests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SearchResultsPage {
    private final WebDriver driver;
    private static final By fourthSearchResult = By.xpath("(//a[@data-testid='result-title-a'])[4]/span");
    Wait<WebDriver> wait;


    public SearchResultsPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void scrollToFourthResult()
    {
        wait = new FluentWait<>(driver)
                .withTimeout(java.time.Duration.ofSeconds(10))
                .pollingEvery(java.time.Duration.ofSeconds(1))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(d -> {
            String script = "arguments[0].scrollIntoView();";
            ((JavascriptExecutor)driver).executeScript(script, d.findElement(fourthSearchResult));
            return true;
        });

    }

    public String getFourthSearchResultText()
    {
        return driver.findElement(fourthSearchResult).getText();
    }

}
