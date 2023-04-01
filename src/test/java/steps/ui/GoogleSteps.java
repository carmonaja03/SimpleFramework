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
    private final TestDataReader testDataReader;
    private final DataFactory dataFactory;
    private PersonalData personalInfo;


    public GoogleSteps() {
        googlePage = PageObjectManager.getGooglePage();
        waitUtils = PageObjectManager.getWaitUtils();
        dataFactory = new DataFactory();
        testDataReader = new TestDataReader();
        personalInfo = new PersonalData();
    }

    @Given("^user goes to google website$")
    public void userGoesToWebsite() {
        googlePage.goToGoogle();
    }

    @And("^user \"(.*)\" inputs \"(.*)\" in the searchbar$")
    public void userInputsInTheSearchbar(String header, String name) {
       String enterSearch = testDataReader.readIni(header, name);
       googlePage.inputSearchBar(enterSearch);
    }

    @And("^user inputs first name \"(.*)\" in the searchbar$")
    public void userInputsInTheSearchbar(String info) {
        personalInfo = dataFactory.createPersonalData(info);
        googlePage.inputInSearchBar(personalInfo.getFirstName());
    }
}
