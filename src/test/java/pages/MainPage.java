package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SettingsTestData;

import java.time.Duration;
import java.util.List;

public class MainPage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final IButton acceptanceBtn = elementFactory.getButton(By.xpath("//div[contains(@class, 'policy-accept')]"), "Acceptance Button");
    private final ITextBox searchBar = elementFactory.getTextBox(By.xpath("//input[contains(@class, 'search-input')]"), "Search Bar");
    private final ILabel currentLoc = elementFactory.getLabel(By.xpath("//div[contains(@class, 'current-location-result')]"), "Current Location");
    private final By SEARCHED_RESULTS = By.xpath("//div[contains(@class, 'source-radar')]");

    public MainPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "AccuWeather")), "Main Page");
    }

    public void clickAcceptPrivacy() {
        acceptanceBtn.click();
    }

    public void searchCity(String name) {
        searchBar.clearAndType(name);
        WebDriver driver = AqualityServices.getBrowser().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SettingsTestData.getEnvData().getWait()));
        wait.until(ExpectedConditions.presenceOfElementLocated(SEARCHED_RESULTS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHED_RESULTS));
    }

    public List<ILabel> getSearchResults() {
        return elementFactory.findElements(SEARCHED_RESULTS, ILabel.class);
    }

    public List<ILabel> getResentLocs() {
        return elementFactory.findElements(By.xpath("//a[contains(@class, 'recent-location-item')]"), ILabel.class);
    }

    public boolean isResultsDisplayed() {
        ILabel resultList = elementFactory.getLabel(By.xpath("//div[contains(@class, 'search-results')]"), "Results List");
        return resultList.state().waitForDisplayed();
    }

    public void clickFirstResult() {
        List<ILabel> results = getSearchResults();
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
        List<ILabel> recentLocs = getResentLocs();
        recentLocs.get(0).click();
    }
}
