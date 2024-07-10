package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "span.user-info")
    private WebElement userName;

    @FindBy(css = "a[href='/mantisbt/view_all_bug_page.php']")
    private WebElement viewIssuesPageButton;

    @FindBy(xpath = "//a[contains(text(), 'Report Issue')]")
    private WebElement reportIssueButton;

//    alternative variant for reportIssueButton
//    @FindBy(xpath = "//span[contains(text(), 'Report Issue')]")
//    private WebElement reportIssueTab;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void goToViewIssuesPage() {
        viewIssuesPageButton.click();
    }

    public void goToReportIssuesPage() {
        reportIssueButton.click();
    }
}