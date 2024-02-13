package utils;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@UtilityClass
public class BrowserUtils{
    private final By HEADER= By.xpath("//h1[contains(@class, 'header-loc')]");

    public void backToMainPage() {
        WebDriver driver = AqualityServices.getBrowser().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SettingsTestData.getEnvData().getWait()));
        wait.until(ExpectedConditions.presenceOfElementLocated(HEADER));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
        AqualityServices.getBrowser().getDriver().navigate().back();
    }
}
