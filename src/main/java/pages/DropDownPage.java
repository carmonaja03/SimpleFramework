package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.PropertyReader;
import utilities.WaitUtils;


public class DropDownPage extends BasePage{
    private final Logger logger = LoggerFactory.getLogger(DropDownPage.class);
    private static final String URL = PropertyReader.getProperty("letCodeDropDown");
    private final WaitUtils waitUtils = new WaitUtils();
    By successNotification = By.cssSelector("div[class='notification is-success']");

    public DropDownPage() {
        setURL(URL);
        logger.debug("loading page..");
    }

    public void selectLanguage(String language){
        By languageDropDown = By.cssSelector("select[id='lang']>option[value='"+language+"']");

            waitUtils.findElement(languageDropDown).click();
            Assert.assertTrue(waitUtils.findElement(successNotification).isDisplayed());
            Assert.assertNotNull(waitUtils.findElement(successNotification));
    }

}
