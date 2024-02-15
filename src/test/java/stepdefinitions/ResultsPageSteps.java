package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ResultsPage;

public class ResultsPageSteps {
    private final ResultsPage resultsPage = new ResultsPage();

    @When("I click Tool menu button and Download as PDF button on the Article page")
    public void clickToolMenuToDownloadPDF() {
        resultsPage.goToDownloadPage();
    }

    @When("I click Tool menu button and Page information button on the Article page")
    public void clickToolMenuAndArticlePage() {
        resultsPage.goToInfoPage();
    }

    @Then("The article page for {string} is open.")
    public void isArticlePageOpen(String name) {
        Assert.assertTrue(resultsPage.state().waitForDisplayed(), "Page for" + name + " was not displayed");
    }
}
