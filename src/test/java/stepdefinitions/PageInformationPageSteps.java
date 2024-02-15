package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.PageInformationPage;

public class PageInformationPageSteps {
    private final PageInformationPage pageInformationPage =  new PageInformationPage();

    @Then("the Information page for Albert Einstein article is displayed")
    public void isInformationPageDisplayed(){
        Assert.assertTrue(pageInformationPage.state().waitForDisplayed(),"Information Page was not displayed");
    }
}
