package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.DriverManager;
import utilities.PropertyReader;
import utilities.WaitUtils;

@Slf4j
public class EditPage extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(EditPage.class);

    By fullNameTextBox = By.xpath("//input[@id='fullName']");
    By appendATextTextBox = By.xpath("//input[@id='join']");
    private final WaitUtils waitUtils = new WaitUtils();

    private static final String URL = PropertyReader.getProperty("letCodeEdit");;

    public EditPage() {
        setURL(URL);
        logger.debug("loading page..");
    }

    public void enterFullName(String name){
        waitUtils.getElementWhenClickable(fullNameTextBox).sendKeys(name);
        logger.debug("enterFullName()..");
    }

    public void enterAppendAText(String enterText) {
        waitUtils.getElementWhenClickable(appendATextTextBox).clear();
        waitUtils.getElementWhenClickable(appendATextTextBox).sendKeys(enterText);
        logger.debug("enterAppendAText()..");

    }

}
