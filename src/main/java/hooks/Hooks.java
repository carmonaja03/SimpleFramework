package hooks;

import io.cucumber.java.*;
import pageobject.PageObjectManager;
import utilities.DriverManager;
import utilities.WaitUtils;

public class Hooks {

    WaitUtils waitUtils;

    String chromePath = "/Users/jasoncarmona/Documents/Automation/SimpleFramework/drivers/chromedriver";


    @Before
    public void initialization(){
        System.setProperty("webdriver.chrome.driver", chromePath);
         DriverManager.initializeDriver();
        PageObjectManager.setDriver(DriverManager.getDriver());
        waitUtils = new WaitUtils(DriverManager.getDriver());
    }


    @After
    public void tearDown() {
        try {
            DriverManager.destroyDriver();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
