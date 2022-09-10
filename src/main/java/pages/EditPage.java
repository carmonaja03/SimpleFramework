package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.PropertyReader;
import utilities.WaitUtils;


public class EditPage extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(EditPage.class);

    By fullNameTextBox = By.xpath("//input[@id='fullName']");
    By appendATextTextBox = By.xpath("//input[@id='join']");
    By disabledTextBox = By.xpath("//input[@id='noEdit' and @class='input']");
    By popUpAd = By.cssSelector("g[class='down']");


    private final WaitUtils waitUtils = new WaitUtils();

    private static final String URL = PropertyReader.getProperty("letCodeEdit");

    public EditPage() {
        setURL(URL);
        logger.debug("loading page..");
    }

    public void enterFullName(String name){
        waitUtils.findElement(fullNameTextBox).sendKeys(name);
        logger.debug("enterFullName()..");
    }

    public void enterAppendAText(String enterText) {
        waitUtils.findElement(appendATextTextBox).clear();
        waitUtils.findElement(appendATextTextBox).sendKeys(enterText);
        logger.debug("enterAppendAText()..");

    }

    public boolean isTextFieldEnabled() {
        if(waitUtils.findElement(popUpAd).isDisplayed()){
            WebElement element = waitUtils.findElement(popUpAd);
            JavascriptExecutor executor = (JavascriptExecutor) element;
            executor.executeScript("arguments[0].click();", element);
        }
        return waitUtils.findElement(disabledTextBox).isEnabled();
    }

}
