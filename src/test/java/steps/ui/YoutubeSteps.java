package steps.ui;

import DataModels.DataFactory;
import DataModels.PersonalData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobject.PageObjectManager;
import pages.GooglePage;
import pages.YoutubePage;
import utilities.PropertyReader;
import utilities.TestDataReader;
import utilities.WaitUtils;

public class YoutubeSteps {
    WaitUtils waitUtils;
    private final YoutubePage youtubePage;

    public YoutubeSteps() {
        youtubePage = PageObjectManager.getYoutubePage();
        waitUtils = PageObjectManager.getWaitUtils();
    }

    @Given("^user goes to youtube website$")
    public void userGoesToWebsite() {
        youtubePage.goToYoutube();
    }

    @And("^user searches \"(.*)\" in the youtube search$")
    public void userSearchesInTheYoutubeSearch(String searchString) {
        youtubePage.searchMusic(searchString);
    }

    @And("^user validates and clicks \"(.*)\" on the search result$")
    public void userValidatesAndClicksOnTheSearchResult(String searchResult) {
        youtubePage.validateSearchResult(searchResult);
    }

    @Then("^user clicks play button$")
    public void userClicksPlayButton() {
        youtubePage.clickPlayButton();
    }

    @And("^user listens to music for \"(.*)\" minutes$")
    public void userListensToMusicTillTheLastPart(int minutes) throws InterruptedException {
        youtubePage.listenToMusic(minutes);
    }
}
