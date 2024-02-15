package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;

public class MainPageSteps {
    private final MainPage mainPage = new MainPage();

    @Given("the Main Page is displayed")
    public void isMainPageDisplayed(){
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page was not Opened");
    }

    @When("I input {string} text in the search field and click submit button")
    public void inputSubjectAndSubmit(String name){
        mainPage.inputTextAndSearch(name);
    }

    @When("I input {string} text in the search field, change search language to {string} and click submit button")
    public void inputSubjectChangeLanguageAndSubmit(String name, String language ){
        mainPage.changeLanguage(language);
        mainPage.inputTextAndSearch(name);
    }
}
