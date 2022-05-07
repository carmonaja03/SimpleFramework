package pageobject;

import lombok.experimental.UtilityClass;
import pages.HomePage;
import pages.EditPage;

@UtilityClass
public class PageObjectManager {
    private HomePage homePage;
    private EditPage inputPage;

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage() : homePage;
    }
    public EditPage getInputPage() {
        return (inputPage == null) ? inputPage = new EditPage() : inputPage;
    }
}
