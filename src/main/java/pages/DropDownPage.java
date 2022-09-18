package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.PropertyReader;
import utilities.WaitUtils;


public class DropDownPage extends BasePage{
    WaitUtils waitUtils;

    private final Logger logger = LoggerFactory.getLogger(DropDownPage.class);
    private static final String URL = PropertyReader.getProperty("letCodeDropDown");

    //** Elements
    By successNotification = By.cssSelector("div[class='notification is-success']");

    //** Constructor
    public DropDownPage(WebDriver driver) {
        super(driver);
        setURL(URL);
        logger.debug("loading page..");
    }

    //** Methods
    public void selectLanguage(String language){
        By languageDropDown = By.cssSelector("select[id='lang']>option[value='"+language+"']");

            waitUtils.findElement(languageDropDown).click();
            Assert.assertTrue(waitUtils.findElement(successNotification).isDisplayed());
            Assert.assertNotNull(waitUtils.findElement(successNotification));
    }

}
