package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ResultsPage;

public class ResultsPageSteps {
    private final ResultsPage resultsPage = new ResultsPage();

    @Then("the City Weather page header contains {string}")
    public void isNameDisplayed(String name) {
        System.out.println(resultsPage.getHeaderName());
        Assert.assertTrue(resultsPage.getHeaderName().contains(name),"Name of search doesn't match header");
    }
}
