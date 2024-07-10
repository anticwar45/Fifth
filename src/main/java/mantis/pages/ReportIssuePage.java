package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtils;

import java.time.Duration;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='summary']")
    private WebElement summaryInput;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[@value='Submit Issue']")
    private WebElement submitIssueButton;

    public void fillReportIssueRequiredFields(String summary, String description) {
        summaryInput.sendKeys(summary);
        descriptionInput.sendKeys(description);
    }

    public void submitForm() {
        TestUtils.scrollToElement(driver, submitIssueButton);
        submitIssueButton.click();
    }

}