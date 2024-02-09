package hooks;


import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SettingsTestData;

import java.time.Duration;


public class Hooks {
    private Browser browser =AqualityServices.getBrowser();

    @Given("the Main page is open")
    public void setUp() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(SettingsTestData.getEnvData().getHost());
    }

    @After
    public void tearDown() {
        browser.quit();
    }
}

