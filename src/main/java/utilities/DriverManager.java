package utilities;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@UtilityClass
    public class DriverManager {

     WebDriver driver = null;
    private static final String browser = getCurrentBrowser();



    public void initializeDriver() {
        if (driver == null) {
            setBrowserDriver(browser);
           // setDriver(driver);
            driver.manage().timeouts();
            driver.manage().window().maximize();
        }
    }

    private static String getCurrentBrowser() {
        String _browser = PropertyReader.getProperty("browser");
        if (_browser == null) {
            _browser = PropertyReader.getProperty("browser");
        }

        return _browser;
    }

    public WebDriver getDriver() {
       return driver;
    }

    public  void setBrowserDriver(String browser) {

        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: "+browser);
        }

    }

    public void setDriver(WebDriver driver){
        DriverManager.driver = driver;
    }

    public void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
