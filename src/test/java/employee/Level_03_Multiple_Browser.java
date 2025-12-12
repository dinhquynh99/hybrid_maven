package employee;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_03_Multiple_Browser extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser"})

    @BeforeClass
    public void beforeClass(String browserName) {
        System.out.println("Run on browser:" + browserName);

        driver = getBrowserDriver(browserName);

        firstName = "Peter";
        lastName = "Crouch";
        emailAddress = "Peter" + new Random().nextInt(9999) + "@gmail.com";
        password = "Testing111###";

    }

    @Test
    public void Employee_01_NewEmployee() {

    }


    @AfterClass
    public void afterClass() {
        driver.quit();

    }

    String firstName, lastName, emailAddress, password, employeeID;

}