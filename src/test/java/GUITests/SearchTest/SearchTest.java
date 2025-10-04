package GUITests.SearchTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends SettingUpTests {

    String searchData  = "TestNG";
    String expectedResult = "TestNG Tutorial";

    @Test
    public void testSearch(){
        homePage.openHomePage();
        homePage.searchFor(searchData);
        // asserting that the fourth search result contains the search term
        searchResultsPage.scrollToFourthResult(); //search rsult page already intialized in SettingUpTests, so no need to create new object (switching on action)
        String actualResult = searchResultsPage.getFourthSearchResultText();
        Assert.assertEquals(actualResult, expectedResult, "result does not match" );
        // actual result would be: TestNG Tutorial - Guru99 >> failure


    }


}
