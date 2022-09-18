package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobject.PageObjectManager;
import pages.DropDownPage;
import utilities.PropertyReader;

public class DropDownSteps {

    private final DropDownPage dropDownPage;
    private static final String URL = PropertyReader.getProperty("letCodeDropDown");

    public DropDownSteps() {
        dropDownPage = PageObjectManager.getDropDownPage();
    }

    @Given("^user goes to letCode dropdown page$")
    public void userGoesToLetCodeEditPage() {
        dropDownPage.setURL(URL);
    }

    @And("^user selects \"(.*)\" programming language$")
    public void userSelectsProgrammingLanguage(String language) {
        dropDownPage.selectLanguage(language);
    }
}
