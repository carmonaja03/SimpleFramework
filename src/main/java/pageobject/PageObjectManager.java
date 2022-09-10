package pageobject;

import lombok.experimental.UtilityClass;
import pages.*;

@UtilityClass
public class PageObjectManager {
    private HomePage homePage;
    private EditPage editPage;
    private DropDownPage dropDownPage;
    private AdvancedTablePage advancedTablePage;
    private UploadDownloadPage uploadDownloadPage;
    private GooglePage googlePage;

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage() : homePage;
    }
    public EditPage getEditPage() {
        return (editPage == null) ? editPage = new EditPage() : editPage;
    }
    public DropDownPage getDropDownPage() {
        return (dropDownPage == null) ? dropDownPage = new DropDownPage() : dropDownPage;
    }
    public AdvancedTablePage getAdvanceTablePage() {
        return (advancedTablePage == null) ? advancedTablePage = new AdvancedTablePage() : advancedTablePage;
    }
    public UploadDownloadPage getUploadDownloadPage() {
        return (uploadDownloadPage == null) ? uploadDownloadPage = new UploadDownloadPage() : uploadDownloadPage;
    }
    public GooglePage getGooglePage() {
        return (googlePage == null) ? googlePage = new GooglePage() : googlePage;
    }
}
