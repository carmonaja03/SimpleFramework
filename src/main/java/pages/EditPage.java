package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.PageObjectManager;
import utilities.PropertyReader;
import utilities.WaitUtils;


public class EditPage extends BasePage {

    WaitUtils waitUtils;

    //** Elements
    By fullNameTextBox = By.xpath("//input[@id='fullName']");
    By appendATextTextBox = By.xpath("//input[@id='join']");
    By disabledTextBox = By.xpath("//input[@id='noEdit' and @class='input']");
    By popUpAd = By.cssSelector("g[class='down']");

    private static final String URL = PropertyReader.getProperty("letCodeEdit");

    //** Constructor
    public EditPage(WebDriver driver) {
        super(driver);
        setURL(URL);
        waitUtils = PageObjectManager.getWaitUtils();
    }

    //** Methods
    public void enterFullName(String name){
        waitUtils.findElement(fullNameTextBox).sendKeys(name);
    }

    public void enterAppendAText(String enterText) {
        waitUtils.findElement(appendATextTextBox).clear();
        waitUtils.findElement(appendATextTextBox).sendKeys(enterText);

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
