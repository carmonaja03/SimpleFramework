package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyReader;
import utilities.WaitUtils;


public class HomePage extends BasePage{

    WaitUtils waitUtils;
    private static final String URL = PropertyReader.getProperty("letCodeTest");

    //** Elements
    By inputButton = By.xpath("//a[@href='/edit']");

    //** Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        setURL(URL);
    }

    //** Methods
    public void clickInput() {
    waitUtils.findElement(inputButton).click();
    }


}
