package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.PageInformationPage;

import static io.qameta.allure.Allure.step;

public class PageInformationPageSteps {
    private final PageInformationPage pageInformationPage = new PageInformationPage();

    @Then("the Information page for Albert Einstein article is displayed")
    public void isInformationPageDisplayed() {
        Assert.assertTrue(pageInformationPage.state().waitForDisplayed(), "Information Page was not displayed");
    }

    @Then("the name {string} is displayed")
    public void isNameDisplayed(String name) {
        step("the name" + name + " is displayed");
        Assert.assertEquals(name, "Albert Einstin", "names are not equal");
    }
}
