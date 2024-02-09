package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;


public class ResultsPage extends Form {
    private static final String NAME="Results";
    private ILabel headerName = AqualityServices.getElementFactory().getLabel(By.xpath("//*[contains(@class, 'header-loc')]"),"Header");

    public ResultsPage(){
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH,NAME)),NAME);
    }

    public String getHeaderName(){
        return headerName.getText();
    }
    public void backToMainPage(){
        AqualityServices.getBrowser().getDriver().navigate().back();
    }
}