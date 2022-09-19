package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageobject.PageObjectManager;
import utilities.PropertyReader;
import utilities.WaitUtils;

public class YoutubePage extends BasePage{
    WaitUtils waitUtils;
    private static final String URL = PropertyReader.getProperty("youtubeSite");

    //** Elements
    By youtubeLogo = By.cssSelector("ytd-topbar-logo-renderer[id='logo']");
    By searchBar = By.cssSelector("input[id='search']");
    By playButton = By.cssSelector("button[class='ytp-play-button ytp-button']");

    //** Constructor
    public YoutubePage(WebDriver driver) {
        super(driver);
        waitUtils = PageObjectManager.getWaitUtils();
    }

    public void goToYoutube() {
        setURL(URL);
    }

    //** Methods
    public void searchMusic(String searchString) {
        waitUtils.findElementClickable(youtubeLogo).isDisplayed();
        waitUtils.findElementClickable(searchBar).sendKeys(searchString);
        waitUtils.findElementClickable(searchBar).sendKeys(Keys.ENTER);
    }

    public void validateSearchResult(String searchResult) {
        By result = By.xpath("//a[@id='video-title']//yt-formatted-string[contains(normalize-space(),'"+searchResult+"')]");
        waitUtils.findElementClickable(result).isDisplayed();
        waitUtils.findElementClickable(result).click();
    }


    public void clickPlayButton() {
        By ads = By.cssSelector("div[class='ytp-ad-text ytp-ad-skip-button-text']");
        playButton = By.cssSelector("button[class='ytp-play-button ytp-button']");

        if (waitUtils.findElementClickable(ads) != null){
            waitUtils.findElementClickable(ads).click();
        }
       // waitUtils.findElementClickable(playButton).click();
    }

    public void listenToMusic(int minutes) throws InterruptedException {
        int listenInSeconds = minutes/60000;
        Thread.sleep(listenInSeconds);
    }
}
