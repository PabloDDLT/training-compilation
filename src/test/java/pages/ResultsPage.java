package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ResultsPage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final ILabel toolsNav = elementFactory.getLabel(By.xpath("//nav[contains(@class, 'tools-landmark')]"), "Tools Nav");
    private final ILink downloadToPDF = elementFactory.getLink(By.xpath("//a[contains(@href, 'Download')]"), "Download Page");
    private final ILink informationPage = elementFactory.getLink(By.xpath("//a[contains(@href, 'action=info')]"), "Information Page");

    public ResultsPage() {
        super(By.xpath("//body[contains(@class,'subject')]"), "Results");
    }

    public void goToDownloadPage() {
        toolsNav.click();
        downloadToPDF.click();
    }

    public void goToInfoPage() {
        toolsNav.click();
        informationPage.click();
    }
}
