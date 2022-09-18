package pages;


import org.openqa.selenium.WebDriver;
import pageobject.PageObjectManager;
import utilities.DriverManager;
import utilities.WaitUtils;

public class BasePage {
    private WebDriver driver = null;
    WaitUtils waitUtils;
    String url = "";

    public BasePage(WebDriver driver) {
    setDriver(driver);
    waitUtils = PageObjectManager.getWaitUtils();
    }

    public void setURL(String url) {
       DriverManager.getDriver().get(url);
    }

    public void getUrl() {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


}
