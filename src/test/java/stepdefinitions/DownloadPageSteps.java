package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DownloadPage;
import utils.FileUtil;

public class DownloadPageSteps {
    private final DownloadPage downloadPage = new DownloadPage();

    @When("I download file from Download as PDF page")
    public void clickDownloadPDF() {
        downloadPage.clickDownload();
    }

    @Then("The file with the name provided on Download as PDF page is downloaded")
    public void isTheFileDownloaded() {
        Assert.assertTrue(FileUtil.isFileExist(FileUtil.isFileInDirectory(downloadPage.downloadedFileName())), "Incorrect file name or file does not exist");
    }
}
