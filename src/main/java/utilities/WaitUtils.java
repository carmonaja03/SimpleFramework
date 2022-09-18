package utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class WaitUtils {
    private static final long Medium = 15L;

    public WaitUtils(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public WebElement findElement(By element, Duration timeout){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException | StaleElementReferenceException e) {
            String message = "Locator " + element + " not clickable after " + timeout + " seconds. " + e.getMessage();
            return null;
        }
    }

    public WebElement findElement(By element){
        return findElement(element, Duration.ofSeconds(Medium));
    }
}
