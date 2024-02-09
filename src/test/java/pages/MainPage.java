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
    //private final IElement resultsContainer = elementFactory.getLabel(By.xpath("//div[contains(@class, 'search-results')]"), "Results Container");
    private final ILabel currentLoc = elementFactory.getLabel(By.xpath("//div[contains(@class, 'current-location-result')]"), "Current Location");

    //TODO: remove index from locator
    private final ILabel recentLoc = elementFactory.getLabel(By.xpath("//a[contains(@class, 'recent-location-item')][1]"), "Recent Location");
    private final By RESULTS_BOX = By.xpath("//div[contains(@class, 'search-bar-result')]");

    // TODO: REMOVE CITYNAME AND RECENTCITY VARIABLES.
    public String cityName;
    public String recentCity;

    public MainPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "AccuWeather")), "Main Page");
    }

    public void clickAcceptPrivacy() {
        acceptanceBtn.click();
    }

    public void searchCity(String name) {
        cityName = name;
        searchBar.clearAndType(name);
    }

    public List<ILabel> getSearchResults() {
        return elementFactory.findElements(RESULTS_BOX, ILabel.class);
    }

    public boolean isCityDisplayed() {
        List<ILabel> results = getSearchResults();
        return results.get(0).state().isDisplayed();
    }

    //TODO: check why the result variable does not show the results generated with the search
    public void clickFirstResult() {
        List<ILabel> results = getSearchResults();
        results.get(1).state().waitForDisplayed();
        results.get(1).click();
    }

    public void clickSearchField() {
        searchBar.click();
    }

    public boolean isCurrentLocDisplayed() {
        return currentLoc.state().isDisplayed();
    }

    public void clickRecentLoc() {
        recentLoc.click();
    }
}
