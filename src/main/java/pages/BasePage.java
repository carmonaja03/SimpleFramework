package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

@Slf4j
public abstract class BasePage {
    private String url;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        log.info("Initializing page.. "+this);
    }

    public void setURL(String url){
      this.url = url;
      log.debug("Setting up URL.. "+this.url);
    }

    public void getUrl() {
        DriverManager.getDriver().get(this.url);
        log.debug("Getting URL.. "+this.url);
    }


}
