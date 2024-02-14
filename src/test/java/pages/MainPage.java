package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class MainPage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final IButton acceptanceBtn = elementFactory.getButton(By.xpath("//div[contains(@class, 'policy-accept')]"), "Acceptance Button");
    private final ITextBox searchBar = elementFactory.getTextBox(By.xpath("//input[contains(@class, 'search-input')]"), "Search Bar");
    private final ILabel currentLoc = elementFactory.getLabel(By.xpath("//div[contains(@class, 'current-location-result')]"), "Current Location");
    private final By SEARCHED_RESULTS = By.xpath("//div[contains(@class, 'source-radar')]");

    public MainPage(String dynamicXPath) {
        super(By.xpath(dynamicXPath), "Main Page");
    }

    public void clickAcceptPrivacy() {
        acceptanceBtn.click();
    }

    public void searchCity(String name) {
        searchBar.clearAndType(name);
        AqualityServices.getConditionalWait().waitFor(() -> !elementFactory.findElements(SEARCHED_RESULTS, ILabel.class).isEmpty());
    }

    public boolean isResultsDisplayed() {
        ILabel resultList = elementFactory.getLabel(By.xpath("//div[contains(@class, 'search-results')]"), "Results List");
        return resultList.state().waitForDisplayed();
    }

    public void clickFirstResult() {
        List<ILabel> results = elementFactory.findElements(SEARCHED_RESULTS, ILabel.class);
        results.get(0).state().waitForDisplayed();
        results.get(0).click();
    }

    public void clickSearchField() {
        searchBar.click();
    }

    public boolean isCurrentLocDisplayed() {
        return currentLoc.state().isDisplayed();
    }

    public void clickRecentLoc() {
        List<ILabel> recentLocs = elementFactory.findElements(By.xpath("//a[contains(@class, 'recent-location-item')]"), ILabel.class);
        recentLocs.get(0).click();
        addHandler();
    }

    public void addHandler() {
        ILabel adFrame = elementFactory.getLabel(By.xpath("//iframe[contains(@id, 'interstitial')]"), "Ad frame");
        AqualityServices.getConditionalWait().waitFor(() -> adFrame.state().isExist(), "Iframe is not present");
        if (adFrame.state().isExist()) {
            AqualityServices.getBrowser().getDriver().switchTo().frame(adFrame.getElement());
            elementFactory.getLabel(By.xpath("//div[contains(@id,'dismiss')]"), "Dismiss btn").click();
            AqualityServices.getBrowser().getDriver().switchTo().defaultContent();
        }
    }
}
