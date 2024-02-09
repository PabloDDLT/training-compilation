package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @When("I consent to data usage in the banner")
    public void consentDataUsage() {
        step("I consent to data usage in the banner");
        mainPage.clickAcceptPrivacy();
    }

    @When("I input {string} in the search field")
    public void searchForCity(String name) {
        step("I input " + name + " in the search field");
        mainPage.searchCity(name);
    }

    @Then("the search results list is displayed")
    public void isResultsDisplayed() {
        step("the search results list is displayed");
        Assert.assertTrue(mainPage.isCityDisplayed());
    }

    @When("I click on the first search result")
    public void clickFirst() {
        step("I click on the first search result");
        mainPage.clickFirstResult();
    }

    @When("I click the search field on the main page")
    public void clickSearchField() {
        step("I click the search field on the main page");
        mainPage.clickSearchField();
    }

    @And("the \"Use your current location\" label is displayed")
    public void currentLocDisplayed() {
        step("the \"Use your current location\" label is displayed");
        Assert.assertTrue(mainPage.currentLocDisplayed());
    }

    @Then("the Main page is opened")
    public void mainPageOpened(){
        step("the Main page is opened");
        Assert.assertTrue(mainPage.mainPageIsOpened());
    }

    @When("I choose the first city in Recent locations")
    public void firstCityRecentLoc(){
        mainPage.clickRecentLoc();
    }
}
