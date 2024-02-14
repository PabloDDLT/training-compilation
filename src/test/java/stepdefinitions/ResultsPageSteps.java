package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ResultsPage;

public class ResultsPageSteps {
    private final ResultsPage resultsPage = new ResultsPage("//body[contains(@class,'search-locations')]");

    @Then("the City Weather page header contains {string}")
    public void isNameDisplayed(String name) {
        Assert.assertTrue(resultsPage.getHeaderName().contains(name),"Name of search doesn't match header");
    }

    @When("I go back to the main page")
    public void goBack(){
        resultsPage.waitForDisplayedAndGoBack();
    }
}
