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

    @And("^user clicks and plays \"(.*)\" on the search result$")
    public void userClicksAndPlaysOnTheSearchResult(String searchResult) {
        youtubePage.clickAndPlaySearchResult(searchResult);
    }

    @Then("^user clicks play button$")
    public void userClicksPlayButton() {
        youtubePage.clickPlayButton();
    }

    @And("^user listens to music for \"(.*)\" minutes$")
    public void userListensToMusicTillTheLastPart(int minutes) {
        youtubePage.listenToMusic(minutes);
    }

    @Then("^user validates that video is playing$")
    public void userValidatesThatVideoIsPlaying() {
        youtubePage.validateVideoIsPlaying();
    }


    @Then("^user clicks and validates any \"(.*)\" channel if it is displayed$")
    public void userClicksAndValidatesChannel(String channelName) {
        youtubePage.clickAndValidatesChannelName(channelName);
    }

}
