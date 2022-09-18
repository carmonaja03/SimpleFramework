package steps.ui;

import DataModels.DataFactory;
import DataModels.PersonalData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobject.PageObjectManager;
import pages.GooglePage;
import utilities.PropertyReader;
import utilities.TestDataReader;
import utilities.WaitUtils;

public class GoogleSteps {
    WaitUtils waitUtils;
    private final GooglePage googlePage;
    private final TestDataReader testDataReader = new TestDataReader();
    private final DataFactory dataFactory = new DataFactory();
    PersonalData personalInfo = new PersonalData();

    private static final String URL = PropertyReader.getProperty("googleSite");

    public GoogleSteps() {
        googlePage = PageObjectManager.getGooglePage();
        waitUtils = PageObjectManager.getWaitUtils();
    }

    @Given("^user goes to google website$")
    public void userGoesToWebsite() {
        googlePage.setURL(URL);
    }

    @And("^user \"(.*)\" inputs \"(.*)\" in the searchbar$")
    public void userInputsInTheSearchbar(String header, String name) {
       String enterSearch = testDataReader.readIni(header, name);
       googlePage.inputSearchBar(enterSearch);
    }

    @And("^user inputs \"(.*)\" in the searchbar$")
    public void userInputsInTheSearchbar(String info) {
        personalInfo = dataFactory.createPersonalData(info);
        googlePage.inputInSearchBar(personalInfo.getFirstName());
    }
}
