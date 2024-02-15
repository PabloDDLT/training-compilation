package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PageInformationPage extends Form {
    public PageInformationPage() {
        super(By.xpath("//body[contains(@class,'action-info')]"), "Page information Page");
    }
}
