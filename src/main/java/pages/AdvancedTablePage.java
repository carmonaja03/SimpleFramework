package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.PropertyReader;

import java.util.List;


public class AdvancedTablePage extends BasePage{
    WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(AdvancedTablePage.class);
    private static final String URL = PropertyReader.getProperty("letCodeAdvancedTable");

    //** Elements
    By searchField = By.cssSelector("input[type='search']");
    By searchResults = By.cssSelector("table[id='advancedtable']>tbody>tr");

    //** Constructor
    public AdvancedTablePage(WebDriver driver) {
        super(driver);
        setURL(URL);
        log.debug("loading page..");
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
                log.info("Found the ff: " + result.getText());
                resultFound = true;
            }
        }
        return resultFound;
    }
}
