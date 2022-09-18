package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.PageObjectManager;
import utilities.PropertyReader;
import utilities.WaitUtils;


public class DropDownPage extends BasePage{
    WaitUtils waitUtils;

    private static final String URL = PropertyReader.getProperty("letCodeDropDown");

    //** Elements
    By successNotification = By.cssSelector("div[class='notification is-success']");

    //** Constructor
    public DropDownPage(WebDriver driver) {
        super(driver);
        setURL(URL);
        waitUtils = PageObjectManager.getWaitUtils();
    }

    //** Methods
    public void selectLanguage(String language){
        By languageDropDown = By.cssSelector("select[id='lang']>option[value='"+language+"']");

            waitUtils.findElement(languageDropDown).click();
            Assert.assertTrue(waitUtils.findElement(successNotification).isDisplayed());
            Assert.assertNotNull(waitUtils.findElement(successNotification));
    }

}
