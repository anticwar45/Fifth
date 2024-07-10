package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewIssueDetailsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ViewIssueDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@class='bug-id']")
    private WebElement bugId;

    @FindBy(xpath = "//td[@class='bug-summary']")
    private WebElement bugSummary;

    @FindBy(xpath = "//td[@class='bug-description']")
    private WebElement bugDescription;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteIssueButton;

    @FindBy(xpath = "//input[@value='Delete Issues']")
    private WebElement approveDeleteIssueButton;

    public String getId() {
        return bugId.getText();
    }

    public String getSummary() {
        return bugSummary.getText();
    }

    public String getDescription() {
        return bugDescription.getText();
    }

    public void deleteIssue() {
        deleteIssueButton.click();
        approveDeleteIssueButton.click();
    }
}