package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pageobject.PageObjectManager;
import pages.AdvancedTablePage;
import utilities.PropertyReader;

public class AdvancedTableSteps {
    private final AdvancedTablePage advancedTablePage;
    private static final String URL = PropertyReader.getProperty("googleSite");

    public AdvancedTableSteps() {
        advancedTablePage = PageObjectManager.getAdvanceTablePage();
    }
    @Given("^user goes to letCode advanced table page$")
    public void userGoesToLetCodeAdvancedTablePage() {
        advancedTablePage.setURL(URL);
    }

    @And("^user searches \"(.*)\" in the search bar$")
    public void userSearchesInTheSearchBar(String searchText) {
        advancedTablePage.searchInAdvancedTable(searchText);
    }


    @And("^user validates that \"(.*)\" result is displayed$")
    public void userValidatesThatResultIsDisplayed(String searchText) {
        Assert.assertTrue(advancedTablePage.validateThatResultIsDisplayed(searchText));
    }
}
