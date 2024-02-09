package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import pages.ResultsPage;

import static io.qameta.allure.Allure.step;

public class ResultsPageSteps {
    private MainPage mainPage = new MainPage();
    private ResultsPage resultsPage = new ResultsPage();

    @Then("the City Weather page header contains name from the search")
    public void isNameDisplayed(){
        step("the City Weather page header contains name from the search");
        Assert.assertTrue(resultsPage.getHeaderName().matches("\\b" + mainPage.cityName + "\\b"));
    }
    @When("I go back to the main page")
    public void backToMainPage(){
        step("I go back to the main page");
        resultsPage.backToMainPage();
    }

    @Then("the City Weather page header contains the city name from the recent locations")
    public void thePageHeaderContainsTheCityNameFromTheRecentLocations() {
        step("the City Weather page header contains the city name from the recent locations");

        Assert.assertTrue(resultsPage.getHeaderName().matches("\\b" + mainPage.recentCity + "\\b"));
    }
}
