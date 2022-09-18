package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.PropertyReader;
import utilities.WaitUtils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadDownloadPage extends BasePage{
     WaitUtils waitUtils;
    private static final String URL = PropertyReader.getProperty("letCodeFile");

    // ** Elements
    private By uploadFileButton = By.cssSelector("svg[data-icon='upload']>path");

    // ** Constructor
    public UploadDownloadPage(WebDriver driver) {
        super(driver);
        setURL(URL);
    }

    // ** Methods
    public void uploadFile() throws AWTException {
        waitUtils.findElement(uploadFileButton).click();
        Robot rb = new Robot();
        StringSelection str = new StringSelection("src/test/resources/data/sample.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}
