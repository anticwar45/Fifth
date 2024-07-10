package mantis.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import mantis.pages.MantisSite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    public WebDriver driver;
    String browser = System.getProperty("browser");

    @BeforeEach
    public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        driver.manage().window().maximize();
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
