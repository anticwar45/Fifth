package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@id='buglist']//tbody//tr")
    private List<WebElement> quantityIssues;

    @FindBy(xpath = "//tr[1]//td[@class='column-id']//a")
    private WebElement lastAddIssue;

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public int getIssuesQuantity() {
        return quantityIssues.size();
    }

    public String getLastAddIssueId() {
        return lastAddIssue.getText();
    }

    public void goToLastAddIssue() {
        lastAddIssue.click();
    }
}
