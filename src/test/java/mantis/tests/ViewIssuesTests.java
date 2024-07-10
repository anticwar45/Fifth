package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ViewIssuesTests extends BaseTest {

    private MantisSite mantisSite;

    @Test
    public void quantityIssuesTest() {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().goToViewIssuesPage();
        int issuesQuantity = mantisSite.getViewIssuesPage().getIssuesQuantity();
        Assertions.assertEquals(50, issuesQuantity);
    }
}