package hooks;

import io.cucumber.java.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobject.PageObjectManager;
import utilities.DriverManager;
import utilities.WaitUtils;

public class Hooks {

    WaitUtils waitUtils;

    private final Logger logger = LoggerFactory.getLogger(Hooks.class);

    String chromePath = "/Users/jasoncarmona/Documents/Automation/SimpleFramework/drivers/chromedriver";


    @Before
    public void initialization(){
        System.setProperty("webdriver.chrome.driver", chromePath);
         DriverManager.initializeDriver();
        PageObjectManager.setDriver(DriverManager.getDriver());
        waitUtils = new WaitUtils(DriverManager.getDriver());
        logger.debug("Starting all scenario..");
    }


    @After
    public void tearDown() {
        try {
            DriverManager.destroyDriver();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        logger.debug("Closing all test..");
    }



}
