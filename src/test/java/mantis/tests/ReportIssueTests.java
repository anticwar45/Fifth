package mantis.tests;

import mantis.pages.MantisSite;
import mantis.pages.ReportIssuePage;
import mantis.pages.ViewIssueDetailsPage;
import mantis.pages.ViewIssuesPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportIssueTests extends BaseTest {

    private MantisSite mantisSite;
    private ReportIssuePage reportIssuePage;
    private SoftAssertions softAssert;
    private WebDriverWait wait;
    private ViewIssuesPage viewIssuesPage;
    private ViewIssueDetailsPage viewIssueDetailsPage;

    @Test
    public void positiveAddDeleteIssue() {
        mantisSite = new MantisSite(driver);
        reportIssuePage = new ReportIssuePage(driver);
        viewIssuesPage = new ViewIssuesPage(driver);
        viewIssueDetailsPage = new ViewIssueDetailsPage(driver);
        softAssert = new SoftAssertions();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuesPage();
        String summary = "Bug report#1";
        String description = "Description#1";
        String bugReportSuccessUrl = "https://academ-it.ru/mantisbt/bug_report.php?posted=1";

        reportIssuePage.fillReportIssueRequiredFields(summary, description);
        reportIssuePage.submitForm();
        softAssert.assertThat(driver.getCurrentUrl()).isEqualTo(bugReportSuccessUrl);
        wait.until(ExpectedConditions.titleContains("View Issues - MantisBT"));
        viewIssuesPage.goToLastAddIssue();

        String id = viewIssueDetailsPage.getId();
        softAssert.assertThat(viewIssueDetailsPage.getSummary()).isEqualTo(viewIssueDetailsPage.getId() + ": " + summary);
        softAssert.assertThat(viewIssueDetailsPage.getDescription()).isEqualTo(description);
        viewIssueDetailsPage.deleteIssue();
        softAssert.assertThat(viewIssuesPage.getLastAddIssueId()).isNotEqualTo(id);

        softAssert.assertAll();
    }
}