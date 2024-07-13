package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportIssueTests extends BaseTest {

    private MantisSite mantisSite;
    private SoftAssertions softAssert;
    private WebDriverWait wait;

    @Test
    public void positiveAddDeleteIssue() {
        mantisSite = new MantisSite(driver);

        softAssert = new SoftAssertions();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToReportIssuesPage();
        String summary = "Bug report#1";
        String description = "Description#1";
        String bugReportSuccessUrl = "https://academ-it.ru/mantisbt/bug_report.php?posted=1";

        mantisSite.getReportIssuePage().fillReportIssueRequiredFields(summary, description);
        mantisSite.getReportIssuePage().submitForm();
        softAssert.assertThat(driver.getCurrentUrl()).isEqualTo(bugReportSuccessUrl);
        wait.until(ExpectedConditions.titleContains("View Issues - MantisBT"));
        mantisSite.getViewIssuesPage().goToLastAddIssue();

        String id = mantisSite.getViewIssueDetailsPage().getId();
        softAssert.assertThat(mantisSite.getViewIssueDetailsPage().getSummary()).isEqualTo(mantisSite.getViewIssueDetailsPage().getId() + ": " + summary);
        softAssert.assertThat(mantisSite.getViewIssueDetailsPage().getDescription()).isEqualTo(description);
        mantisSite.getViewIssueDetailsPage().deleteIssue();
        softAssert.assertThat(mantisSite.getViewIssuesPage().getLastAddIssueId()).isNotEqualTo(id);

        softAssert.assertAll();
    }
}