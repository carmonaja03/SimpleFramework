package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pageobject.PageObjectManager;
import pages.AdvancedTablePage;
import pages.DropDownPage;

public class AdvancedTableSteps {
    private final AdvancedTablePage advancedTablePage;

    public AdvancedTableSteps() {
        advancedTablePage = PageObjectManager.getAdvanceTablePage();
    }
    @Given("^user goes to letCode advanced table page$")
    public void userGoesToLetCodeAdvancedTablePage() {
        advancedTablePage.getUrl();
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
