package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobject.PageObjectManager;
import pages.UploadDownloadPage;
import utilities.PropertyReader;

import java.awt.*;

public class UploadDownloadSteps {

    private final UploadDownloadPage uploadDownloadPage;
    private static final String URL = PropertyReader.getProperty("googleSite");

    public UploadDownloadSteps() {
        uploadDownloadPage = PageObjectManager.getUploadDownloadPage();
    }

    @Given("^user goes to letCode file page$")
    public void userGoesToFilePage() {
        uploadDownloadPage.setURL(URL);
    }

    @And("user clicks upload file")
    public void userClicksUploadFile() throws AWTException {
        uploadDownloadPage.uploadFile();
    }
}
