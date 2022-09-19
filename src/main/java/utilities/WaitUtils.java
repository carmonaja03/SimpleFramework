package utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitUtils {
    private static final long Medium = 15L;

    public WaitUtils(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public WebElement findElementClickable(By element, Duration timeout){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException | StaleElementReferenceException e) {
            String message = "Locator " + element + " not clickable after " + timeout + " seconds. " + e.getMessage();
            return null;
        }
    }

    public WebElement findElementClickable(By element){
        return findElementClickable(element, Duration.ofSeconds(Medium));
    }
}
