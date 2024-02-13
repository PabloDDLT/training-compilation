package stepdefinitions;

import io.cucumber.java.en.When;
import utils.BrowserUtils;

public class BrowserSteps {
    @When("I go back to the main page")
    public void backToMainPage() {
        BrowserUtils.backToMainPage();
    }
}
