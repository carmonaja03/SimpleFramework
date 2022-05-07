package pages;

import io.cucumber.messages.Messages;
import io.cucumber.plugin.event.Node;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.DriverManager;
import utilities.PropertyReader;
import utilities.WaitUtils;

@Slf4j
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
    waitUtils.getElementWhenClickable(inputButton).click();
        logger.debug("clicking..");
    }


}
