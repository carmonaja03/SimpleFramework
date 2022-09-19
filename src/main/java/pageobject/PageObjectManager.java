package pageobject;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.WaitUtils;

@UtilityClass
public class PageObjectManager {
    private GooglePage googlePage;
    WebDriver driver;
    private WaitUtils waitUtils;
    private YoutubePage youtubePage;

    public GooglePage getGooglePage() {
        return (googlePage == null) ? googlePage = new GooglePage(driver) : googlePage;
    }
    public YoutubePage getYoutubePage() {
        return (youtubePage == null) ? youtubePage = new YoutubePage(driver) : youtubePage;
    }

    public WaitUtils getWaitUtils() {
        return (waitUtils == null) ? waitUtils = new WaitUtils(driver) : waitUtils;
    }

    public void setDriver(WebDriver driver) {
        PageObjectManager.driver = driver;
    }

}
