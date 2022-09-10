package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobject.PageObjectManager;
import pages.DropDownPage;

public class DropDownSteps {

    private final DropDownPage dropDownPage;

    public DropDownSteps() {
        dropDownPage = PageObjectManager.getDropDownPage();
    }

    @Given("^user goes to letCode dropdown page$")
    public void userGoesToLetCodeEditPage() {
        dropDownPage.getUrl();
    }

    @And("^user selects \"(.*)\" programming language$")
    public void userSelectsProgrammingLanguage(String language) {
        dropDownPage.selectLanguage(language);
    }
}
