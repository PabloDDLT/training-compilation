package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final ILabel languageLbl = elementFactory.getLabel(By.xpath("//div[contains(@class,'hide-arrow')]"), "Language label");
    private final ITextBox searchInput = elementFactory.getTextBox(By.id("searchInput"), "Searching Bar");
    private final IButton submitBtn = elementFactory.getButton(By.xpath("//button[contains(@type, 'submit')]"), "Submit");

    public MainPage() {
        super(By.xpath("//body[contains(@id,'wikipedia-org')]"), "Main Page");
    }

    public void inputTextAndSearch(String text) {
        searchInput.clearAndType(text);
        submitBtn.click();
    }

    public void changeLanguage(String language) {
        languageLbl.click();
        String customXPath = "//option[contains(text(), '" + language + "')]";
        elementFactory.getLabel(By.xpath(customXPath), "Desired Language").click();
    }
}
