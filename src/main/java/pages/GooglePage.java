package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageobject.PageObjectManager;
import utilities.PropertyReader;
import utilities.WaitUtils;

public class GooglePage extends BasePage{
    WaitUtils waitUtils;
    private static final String URL = PropertyReader.getProperty("googleSite");

    //** Elements
    By searchBar = By.cssSelector("input[name='q']");

    //** Constructor
    public GooglePage(WebDriver driver) {
        super(driver);
        setURL(URL);
        waitUtils = PageObjectManager.getWaitUtils();
    }

    //** Methods
    public void inputSearchBar(String searchItem){
        waitUtils.findElement(searchBar).sendKeys(searchItem + Keys.ENTER);
    }

    public void inputInSearchBar(String firstName) {
        waitUtils.findElement(searchBar).sendKeys(firstName + Keys.ENTER);
    }
}
