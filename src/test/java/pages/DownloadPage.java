package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DownloadPage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final ILabel fileNameLbl = elementFactory.getLabel(By.xpath("//div[contains(@class, 'label-desc')]"), "File Name");
    private final IButton downloadBtn = elementFactory.getButton(By.xpath("//button[contains(@type, 'submit')]"), "Download Button");

    public DownloadPage() {
        super(By.xpath("//body[contains(@class,'Download')]"), "Download Page");
    }

    public void clickDownload() {
        downloadBtn.click();
    }

    public String downloadedFileName() {
        return fileNameLbl.getText();
    }
}
