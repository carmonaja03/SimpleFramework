package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageobject.PageObjectManager;
import utilities.PropertyReader;
import utilities.WaitUtils;

import java.time.Duration;

public class YoutubePage extends BasePage{
    WaitUtils waitUtils;
    private static final String URL = PropertyReader.getProperty("youtubeSite");

    //** Elements
    By youtubeLogo = By.cssSelector("ytd-topbar-logo-renderer[id='logo']");
    By searchBar = By.cssSelector("input[id='search']");
    By playButton = By.cssSelector("button[class='ytp-play-button ytp-button'][title='Play (k)']");
    By pauseButton = By.cssSelector("button[class='ytp-play-button ytp-button'][title='Pause (k)']");

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

    public void clickAndPlaySearchResult(String searchResult) {
        By result = By.xpath("//a[@id='video-title']//yt-formatted-string[contains(normalize-space(),'"+searchResult+"')]");
        By ads = By.cssSelector("div[class='ytp-ad-text ytp-ad-skip-button-text']");

        waitUtils.findElementClickable(result).isDisplayed();
        waitUtils.findElementClickable(result).click();

        if (waitUtils.findElementClickable(ads) != null){
            waitUtils.findElementClickable(ads).click();
        }
    }


    public void clickPlayButton() {
        By ads = By.cssSelector("div[class='ytp-ad-text ytp-ad-skip-button-text']");
        playButton = By.cssSelector("button[class='ytp-play-button ytp-button']");

        if (waitUtils.findElementClickable(ads) != null){
            waitUtils.findElementClickable(ads).click();
        }
        waitUtils.findElementClickable(playButton).click();
    }

    public void listenToMusic(int minutes) {
        By playTillEnd = By.cssSelector("div[class='ytp-scrubber-container'][style='transform: translateX(1394px);']");
        int listenInSeconds = minutes/60000;
        waitUtils.waitElementToBeVisible(playTillEnd, Duration.ofSeconds(listenInSeconds)).isDisplayed();
    }

    public void validateVideoIsPlaying() {
        waitUtils.findElementClickable(pauseButton).isDisplayed();

    }
}
