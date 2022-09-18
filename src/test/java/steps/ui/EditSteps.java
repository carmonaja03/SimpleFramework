package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pageobject.PageObjectManager;
import pages.EditPage;
import utilities.PropertyReader;

public class EditSteps {

    private final EditPage editPage;
    private static final String URL = PropertyReader.getProperty("letCodeEdit");

    public EditSteps() {
        editPage = PageObjectManager.getEditPage();
    }

    @Given("^user goes to letCode edit page$")
    public void userGoesToLetCodeEditPage() {
        editPage.setURL(URL);
    }

    @And("^user enters full name \"(.*)\"$")
    public void userEntersFullName(String name) {
        editPage.enterFullName(name);
    }

    @And("^user enters \"(.*)\" on append a text$")
    public void userEntersOnAppendAText(String enterText) {
        editPage.enterAppendAText(enterText);
    }

    @And("^user confirms that the field is disabled$")
    public void userConfirmsThatTheFieldIsDisabled() {
        Assert.assertTrue("Textbox is disabled", editPage.isTextFieldEnabled());

    }
}
