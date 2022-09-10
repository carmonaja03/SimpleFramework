package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.DriverManager;
import utilities.WaitUtils;

public abstract class BasePage {
    private final Logger log = LoggerFactory.getLogger(BasePage.class);
    public final WaitUtils waitUtils = new WaitUtils();
    private String url;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        log.warn("Initializing page.. ");
    }

    public void setURL(String url){
      this.url = url;
      log.trace("Setting up URL.. "+this.url);
    }

    public void getUrl() {
        DriverManager.getDriver().get(this.url);
        log.debug("Getting URL.. "+this.url);
    }

}
