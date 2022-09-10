package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
    private static WebDriver driver;
    private static final String browser = getCurrentBrowser();

    public static void initializeDriver() {
        if (driver == null) {
            setBrowserDriver(browser);
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

    public static WebDriver getDriver() {
       return driver;
    }

    public static void setBrowserDriver(String browser) {

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

    public static WebDriver setChromeDriver(){
        driver = new ChromeDriver();
        return driver;
    }

    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

    private DriverManager() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
