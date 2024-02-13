package hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.SettingsTestData;

public class Hooks {

    @Before
    public void setUp() {
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(SettingsTestData.getEnvData().getHost());
    }

    @After
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
