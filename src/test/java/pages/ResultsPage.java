package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.BrowserUtils;

public class ResultsPage extends Form {
    private final ILabel headerName = AqualityServices.getElementFactory().getLabel(By.xpath("//h1[contains(@class, 'header-loc')]"), "Header");

    public ResultsPage(String dynamicXPath) {
        super(By.xpath(dynamicXPath), "Results");
    }

    public void waitForDisplayedAndGoBack() {
        AqualityServices.getConditionalWait().waitFor(() -> headerName.state().waitForDisplayed());
        BrowserUtils.backToMainPage();
    }

    public String getHeaderName() {
        return headerName.getText();
    }
}
