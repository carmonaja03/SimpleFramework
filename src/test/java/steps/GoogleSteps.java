package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobject.PageObjectManager;
import pages.AdvancedTablePage;
import pages.GooglePage;
import utilities.TestDataReader;

import java.io.IOException;

public class GoogleSteps {
    private final GooglePage googlePage;
    TestDataReader testDataReader = new TestDataReader();

    public GoogleSteps() {
        googlePage = PageObjectManager.getGooglePage();
    }

    @Given("^user goes to google website$")
    public void userGoesToWebsite() {
        googlePage.getUrl();
    }

    @And("^user \"(.*)\" inputs \"(.*)\" in the searchbar$")
    public void userInputsInTheSearchbar(String header, String name) throws IOException {
       String enterSearch = testDataReader.readIni(header, name);
       googlePage.inputSearchBar(enterSearch);
    }
}
