package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobject.PageObjectManager;
import pages.HomePage;
import utilities.PropertyReader;

public class HomeSteps {
    private final HomePage homePage;
    private static final String URL = PropertyReader.getProperty("googleSite");

    public HomeSteps() {
        homePage = PageObjectManager.getHomePage();
    }

    @Given("^user goes to letCode website$")
    public void userGoesToLetCodeWebsite() {
        homePage.setURL(URL);
    }

    @And("^user clicks input button$")
    public void userClicksInputButton() {
        homePage.clickInput();
    }
}
