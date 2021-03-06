package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobject.PageObjectManager;
import pages.HomePage;

public class HomeSteps {

    private final HomePage homePage;

    public HomeSteps() {
        homePage = PageObjectManager.getHomePage();
    }

    @Given("^user goes to letCode website$")
    public void userGoesToLetCodeWebsite() {
        homePage.getUrl();
        System.out.println("Edit Steps > iGoToLetCodeWebsite()...");
    }

    @And("^user clicks input button$")
    public void userClicksInputButton() {
        homePage.clickInput();
        System.out.println("Edit Steps > I iClickInputButton()....");
    }
}
