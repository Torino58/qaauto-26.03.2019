package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchPage;
import page.SearchResultsPage;
import page.SearchResultsSecondPage;

import java.util.List;

public class SearchTest extends BaseTest{
    String searchTerm = "Selenium";

    @Test()
    public void basicSearchTest(){
        int elementCountFirstPage = 9;
        int elementCountSecondPage = 10;

        Assert.assertTrue(searchPage.isPageLoaded(), "Landing page is not loaded");

        SearchResultsPage searchResultsPage = searchPage.searchWord(searchTerm);

        Assert.assertTrue(searchResultsPage.isPageLoaded(), "Landing page is not loaded");

        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), elementCountFirstPage, "Search results count is wrong");

        List<String> searchResultsListFirstPage = searchResultsPage.getSearchResultsList();

        for (String searchResult : searchResultsListFirstPage) {

            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm Selenium" + searchTerm + "not found in:\n" + searchResult);
        }
        SearchResultsSecondPage searchResultsSecondPage = searchResultsPage.secondPage();

        Assert.assertTrue(searchResultsSecondPage.isPageLoaded(), "Landing page is not loaded");

        Assert.assertEquals(searchResultsSecondPage.getSearchResultsCount(), elementCountSecondPage, "Search results count is wrong");

        List<String> searchResultsListSecondPage = searchResultsSecondPage.getSearchResultsList();

        for (String searchResult : searchResultsListSecondPage) {

            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm Selenium" + searchTerm + "not found in:\n" + searchResult);
        }

    }

}
