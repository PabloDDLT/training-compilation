package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;

public class MainPageSteps {
    private final MainPage mainPage = new MainPage("//body[contains(@class,'home')]");

    @Given("I consent to data usage in the banner")
    public void consentDataUsage() {
        mainPage.clickAcceptPrivacy();
    }

    @When("I input {string} in the search field")
    public void searchForCity(String name) {
        mainPage.searchCity(name);
    }

    @Then("the search results list is displayed")
    public void isResultsDisplayed() {
        Assert.assertTrue(mainPage.isResultsDisplayed(), "No results were displayed");
    }

    @When("I click on the first search result")
    public void clickFirst() {
        mainPage.clickFirstResult();
    }

    @When("I click the search field on the main page")
    public void clickSearchField() {
        mainPage.clickSearchField();
    }

    @And("the 'Use your current location' label is displayed")
    public void currentLocDisplayed() {
        Assert.assertTrue(mainPage.isCurrentLocDisplayed(), "'Use your current location' Label not Displayed");
    }

    @Then("the Main page is opened")
    public void isMainPageOpen() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page was not Opened");
    }

    @When("I choose the first city in Recent locations")
    public void clickFirstRecentLoc() {
        mainPage.clickRecentLoc();
    }
}
