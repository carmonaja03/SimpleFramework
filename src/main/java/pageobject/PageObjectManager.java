package pageobject;

import hooks.Hooks;
import io.cucumber.messages.types.Hook;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.DriverManager;
import utilities.WaitUtils;

@UtilityClass
public class PageObjectManager {
    private HomePage homePage;
    private EditPage editPage;
    private DropDownPage dropDownPage;
    private AdvancedTablePage advancedTablePage;
    private UploadDownloadPage uploadDownloadPage;
    private GooglePage googlePage;
    WebDriver driver;
    private WaitUtils waitUtils;

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
    public EditPage getEditPage() {
        return (editPage == null) ? editPage = new EditPage(driver) : editPage;
    }
    public DropDownPage getDropDownPage() {
        return (dropDownPage == null) ? dropDownPage = new DropDownPage(driver) : dropDownPage;
    }
    public AdvancedTablePage getAdvanceTablePage() {
        return (advancedTablePage == null) ? advancedTablePage = new AdvancedTablePage(driver) : advancedTablePage;
    }
    public UploadDownloadPage getUploadDownloadPage() {
        return (uploadDownloadPage == null) ? uploadDownloadPage = new UploadDownloadPage(driver) : uploadDownloadPage;
    }
    public GooglePage getGooglePage() {
        return (googlePage == null) ? googlePage = new GooglePage(driver) : googlePage;
    }
    public WaitUtils getWaitUtils() {
        return (waitUtils == null) ? waitUtils = new WaitUtils(driver) : waitUtils;
    }

    public void setDriver(WebDriver driver) {
        PageObjectManager.driver = driver;
    }

}
