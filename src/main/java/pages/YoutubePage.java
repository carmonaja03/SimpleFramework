package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.PageObjectManager;
import utilities.DriverManager;
import utilities.PropertyReader;
import utilities.WaitUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class YoutubePage extends BasePage {
    WaitUtils waitUtils;
    private static final String URL = PropertyReader.getProperty("youtubeSite");

    //** Elements
    By youtubeLogo = By.cssSelector("ytd-topbar-logo-renderer[id='logo']");
    By searchBar = By.cssSelector("input[id='search']");
    By playButton = By.cssSelector("button[class='ytp-play-button ytp-button'][title='Play (k)']");
    By pauseButton = By.cssSelector("button[class='ytp-play-button ytp-button'][title='Pause (k)']");
    By youtubeChannels = By.cssSelector("div[class='style-scope ytd-channel-name']>yt-formatted-string>a");

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
        By result = By.xpath("//a[@id='video-title']//yt-formatted-string[contains(normalize-space(),'" + searchResult + "')]");
        By ads = By.cssSelector("div[class='ytp-ad-text ytp-ad-skip-button-text']");

        waitUtils.findElementClickable(result).isDisplayed();
        waitUtils.findElementClickable(result).click();

        if (waitUtils.findElementClickable(ads) != null) {
            waitUtils.findElementClickable(ads).click();
        }
    }


    public void clickPlayButton() {
        By ads = By.cssSelector("div[class='ytp-ad-text ytp-ad-skip-button-text']");
        playButton = By.cssSelector("button[class='ytp-play-button ytp-button']");

        if (waitUtils.findElementClickable(ads) != null) {
            waitUtils.findElementClickable(ads).click();
        }
        waitUtils.findElementClickable(playButton).click();
    }

    public void listenToMusic(int minutes) {
        By playTillEnd = By.cssSelector("div[class='ytp-scrubber-container'][style='transform: translateX(1394px);']");
        int listenInSeconds = minutes / 60000;
        waitUtils.waitElementToBeVisible(playTillEnd, Duration.ofSeconds(listenInSeconds)).isDisplayed();
    }

    public void validateVideoIsPlaying() {
        waitUtils.findElementClickable(pauseButton).isDisplayed();

    }

    public void clickAndValidatesChannelName(String channelName) {
        By youtubeChannelName = By.xpath("//div[@id='channel-header']//div[@class='style-scope ytd-channel-name']//yt-formatted-string[contains(normalize-space(),'"+channelName+"')]");
        ArrayList<String> channelNames = new ArrayList<>();
        List<WebElement> channels = DriverManager.getDriver().findElements(youtubeChannels);
        waitUtils.findElementClickable(youtubeLogo).isDisplayed();

        for (WebElement channel : channels) {
            channelNames.add(channel.getText());
            if (channel.getText().equalsIgnoreCase(channelName)) {
                    waitUtils.findElementClickable(channel).click();
                    break;
            }
        }

        System.out.println("Channel names: "+channelNames);
        try {
            waitUtils.findElementClickable(youtubeChannelName).isDisplayed();
        } catch (Exception e){
            System.out.println("No channel found");
        }
    }

    /**
     * @param sideMenu
     */
    public void clickSideMenu(String sideMenu) {
        By sideMenuButton = By.xpath("//tp-yt-paper-item[@class='style-scope ytd-guide-entry-renderer']//yt-formatted-string[contains(text(),'"+sideMenu+"')]");
        waitUtils.findElementClickable(sideMenuButton).click();
    }

    /**
     * @param section
     */
    public void clickExploreSection(String section) {
        By exploreSectionButton = By.xpath("//div[@id='destination-buttons']//yt-formatted-string[contains(text(), '"+section+"')]");
        waitUtils.findElementClickable(exploreSectionButton).click();
    }

    /**
     * @param channel
     */
    public void validateChannelIsDisplayed(String channel) {
        By channelHeader = By.xpath("//h1//yt-formatted-string[@id='title' and contains(text(),'"+channel+"')]");
        Assert.assertTrue(waitUtils.findElementClickable(channelHeader).isDisplayed());
    }
}
