package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.PageObjectManager;
import utilities.PropertyReader;
import utilities.WaitUtils;

import java.util.List;


public class AdvancedTablePage extends BasePage{
    WebDriver driver;
    WaitUtils waitUtils;
    private static final String URL = PropertyReader.getProperty("letCodeAdvancedTable");

    //** Elements
    By searchField = By.cssSelector("input[type='search']");
    By searchResults = By.cssSelector("table[id='advancedtable']>tbody>tr");

    //** Constructor
    public AdvancedTablePage(WebDriver driver) {
        super(driver);
        setURL(URL);
        waitUtils = PageObjectManager.getWaitUtils();
    }

    //** Methods
    public void searchInAdvancedTable(String searchText){
        waitUtils.findElement(searchField).sendKeys(searchText);
    }

    public boolean validateThatResultIsDisplayed(String searchText){
        boolean resultFound = false;
        List<WebElement> results = driver.findElements(searchResults);
        for (WebElement result : results) {
            if (result.getText().contains(searchText)) {
                resultFound = true;
            }
        }
        return resultFound;
    }
}
