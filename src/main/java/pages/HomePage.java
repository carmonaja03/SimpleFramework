package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.PropertyReader;
import utilities.WaitUtils;


public class HomePage extends BasePage{

    private final Logger logger = LoggerFactory.getLogger(HomePage.class);
    private final WaitUtils waitUtils = new WaitUtils();

    By inputButton = By.xpath("//a[@href='/edit']");

    private static final String URL = PropertyReader.getProperty("letCodeTest");

    public HomePage() {
        setURL(URL);
        logger.debug("loading page..");
    }

    public void clickInput() {
    waitUtils.findElement(inputButton).click();
        logger.debug("clicking..");
    }


}
