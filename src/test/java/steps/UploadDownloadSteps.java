package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobject.PageObjectManager;
import pages.UploadDownloadPage;

import java.awt.*;

public class UploadDownloadSteps {

    private final UploadDownloadPage uploadDownloadPage;

    public UploadDownloadSteps() {
        uploadDownloadPage = PageObjectManager.getUploadDownloadPage();
    }

    @Given("^user goes to letCode file page$")
    public void userGoesToFilePage() {
        uploadDownloadPage.getUrl();
    }

    @And("user clicks upload file")
    public void userClicksUploadFile() throws AWTException {
        uploadDownloadPage.uploadFile();
    }
}
