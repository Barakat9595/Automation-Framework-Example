package GUITests.SearchTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SettingUpTests {

    String searchData  = "TestNG";
    String expectedResult = "TestNG Tutorial";

    @Test
    public void testSearch(){
        homePage.openHomePage();
        searchResultsPage = homePage.searchFor(searchData);
        // asserting that the fourth search result contains the search term
        searchResultsPage.scrollToFourthResult();
        String actualResult = searchResultsPage.getFourthSearchResultText();
        Assert.assertEquals(actualResult, expectedResult, "result does not match" );
        // actual result would be: TestNG Tutorial - Guru99 >> failure


    }


}
