package hooks;

import io.cucumber.java.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import utilities.DriverManager;


public class Hooks {

    private final Logger logger = LoggerFactory.getLogger(Hooks.class);

    String chromePath = "/Users/jasoncarmona/Documents/Automation/SimpleFramework/drivers/chromedriver";

    @Before
    public void initialization(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        DriverManager.initializeDriver();
        logger.debug("Starting all scenario..");
    }

    @After
    public void afterScenario() throws InterruptedException {
        Thread.sleep(2000);
        DriverManager.destroyDriver();
        logger.debug("Closing all test..");
    }



}
