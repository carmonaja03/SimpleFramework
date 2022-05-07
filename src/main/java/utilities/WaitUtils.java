package utilities;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@Slf4j
public class WaitUtils {
    private final Logger logger = LoggerFactory.getLogger(WaitUtils.class);
    private static final long Medium = 15L;
    private final WebDriver driver;

    public WaitUtils() {
        this.driver = DriverManager.getDriver();
    }

    public WebElement getElementWhenClickable(By element, Duration timeout){
            try {
                WebDriverWait wait = new WebDriverWait(driver, timeout);
                logger.info("getElementWhenClickable()..");
                return wait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (TimeoutException | StaleElementReferenceException e) {
                String message = "Locator " + element + " not clickable after " + timeout + " seconds. " + e.getMessage();
                return null;
            }
    }

     public WebElement getElementWhenClickable(By element){
        return getElementWhenClickable(element, Duration.ofSeconds(Medium));
    }
}
