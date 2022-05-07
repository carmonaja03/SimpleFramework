package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobject.PageObjectManager;
import pages.EditPage;
import utilities.PropertyReader;

public class EditSteps {

    private final EditPage editPage;


    public EditSteps() {
        editPage = PageObjectManager.getInputPage();
    }

    @Given("^user goes to letCode edit page$")
    public void userGoesToLetCodeEditPage() {
        editPage.getUrl();
        System.out.println("Edit Steps > userGoesToLetCodeEditPage()...");
    }

    @And("^user enters full name \"(.*)\"$")
    public void userEntersFullName(String name) {
        editPage.enterFullName(name);
    }

    @And("^user enters \"(.*)\" on append a text$")
    public void userEntersOnAppendAText(String enterText) {
        editPage.enterAppendAText(enterText);
    }
}
