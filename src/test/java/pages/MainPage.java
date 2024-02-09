package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;


public class MainPage extends Form {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private IButton acceptanceBtn = elementFactory.getButton(By.xpath("//*[contains(@class, 'policy-accept')]"), "Acceptance Button");
    private ITextBox searchBar = elementFactory.getTextBox(By.xpath("//*[contains(@class, 'search-input')]"), "Search Bar");
    private IElement resultsContainer = elementFactory.getLabel(By.xpath("//div[contains(@class, 'search-results')]"), "Results Container");
    public List<ILabel> results = elementFactory.findElements(By.xpath("//div[contains(@class, 'source-accuweather')]"), ILabel.class);
    private ILabel currentLoc = elementFactory.getLabel(By.xpath("//div[contains(@class, 'current-location-result')]"), "Current Location");
    private ILabel recentLoc = elementFactory.getLabel(By.xpath("//a[contains(@class, 'recent-location-item')][1]"), "Recent Location");

    public String cityName;
    public String recentCity;

    public MainPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "AccuWeather")), "Main Page");
    }

    public void clickAcceptPrivacy() {
        acceptanceBtn.click();
    }

    public void searchCity(String name) {
        this.cityName = name;
        searchBar.clearAndType(name);
    }

    public boolean isCityDisplayed() {
        return resultsContainer.state().waitForDisplayed();

    }


    public void clickFirstResult() {

        results.get(0).state().waitForDisplayed();
        results.get(0).click();
    }

    public void clickSearchField() {
        searchBar.click();
    }

    public boolean currentLocDisplayed() {
        return currentLoc.state().isDisplayed();
    }

    public boolean mainPageIsOpened() {
        return currentLoc.state().isDisplayed();
    }

    public void clickRecentLoc() {
        recentCity = recentLoc.getText();
        recentLoc.click();
    }
}
