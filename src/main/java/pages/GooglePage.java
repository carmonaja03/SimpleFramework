package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.PropertyReader;
import utilities.WaitUtils;

public class GooglePage extends BasePage{
    private final Logger log = LoggerFactory.getLogger(GooglePage.class);
    private static final String URL = PropertyReader.getProperty("googleSite");
    By searchBar = By.cssSelector("input[name='q']");

    public GooglePage() {
        setURL(URL);
        log.info("loading page..");
    }

    public void inputSearchBar(String searchItem){
        waitUtils.findElement(searchBar).sendKeys(searchItem + Keys.ENTER);
    }

}
