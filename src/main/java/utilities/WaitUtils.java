package utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitUtils {
    private static final long Medium = 20L;

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
    public WebElement findElementClickable(WebElement element, Duration timeout){
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
    public WebElement findElementClickable(WebElement element){
        return findElementClickable(element, Duration.ofSeconds(Medium));
    }

    public WebElement waitElementToBeVisible(By element, Duration timeout){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException | StaleElementReferenceException e) {
            String message = "Locator " + element + " not visible after " + timeout + " seconds. " + e.getMessage();
            return null;
        }
    }

    public void clickJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click()", element);
    }
    public void clickJS(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        clickJS(element);
    }

}
