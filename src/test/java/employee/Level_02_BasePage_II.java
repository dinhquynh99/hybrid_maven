package employee;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_II {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        basePage = BasePage.getBasePage();

        firstName = "Peter";
        lastName = "Crouch";
        emailAddress = "Peter" + new Random().nextInt(9999) + "@gmail.com";
        password = "Testing111###";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void Employee_01_NewEmployee() {
        basePage.openPageURL(driver, "http://localhost:88/orangehrm/");

        basePage.senkeyToElement(driver, "//input[@name='username']", "automationfc");
        basePage.senkeyToElement(driver, "//input[@name='password']", "Auto222$$$");
        basePage.clickToElement(driver, "//button[contain(@class,'orangehrm-login-button')]");

        Assert.assertTrue(basePage.isloadingIconDisappear(driver));

        Assert.assertTrue(basePage.isElementDisplay(driver, "//h6[text()='Dashbroard']"));

        basePage.clickToElement(driver, "//span[text()='PIM']/parent::a");
        Assert.assertTrue(basePage.isloadingIconDisappear(driver));

        Assert.assertTrue(basePage.isElementDisplay(driver, "//h6[text()='PIM']"));

        basePage.clickToElement(driver, "//a[text()='Add Employee']");
        Assert.assertTrue(basePage.isloadingIconDisappear(driver));

        basePage.senkeyToElement(driver, "//input[@name='firstName']", firstName);
        basePage.senkeyToElement(driver, "//input[@name='lastname']", lastName);

        employeeID = basePage.getElementDomProperty(driver, "//label[text()='Employee Id']/parent::div/following-sibling::div/input", "value");
        basePage.clickToElement(driver, "//p[text()='Create Login Details']/following-sibling::div//span");
        basePage.sleepInSecond(2);

        basePage.senkeyToElement(driver, "//label[text()='Username']/parent::div/following-sibling::div/input", emailAddress);
        basePage.senkeyToElement(driver, "//label[text()='Password']/parent::div/following-sibling::div/input", password);
        basePage.senkeyToElement(driver, "//label[text()='Confirm Password']/parent::div/following-sibling::div/input", password);

        basePage.clickToElement(driver, "//button[contains(string(),'Save')]");
        basePage.sleepInSecond(2);

        Assert.assertTrue(basePage.isElementDisplay(driver,"//p[text()='Successfully Saved']"));
        Assert.assertTrue(basePage.isloadingIconDisappear(driver));

       Assert.assertEquals(basePage.getElementDomProperty(driver, "//input[@name='firstName']", "value"), firstName);;
       Assert.assertEquals(basePage.getElementDomProperty(driver, "//input[@name='lastName']", "value"), lastName);;
       Assert.assertEquals(basePage.getElementDomProperty(driver, "//label[text()='Employee Id']/parent::div/following-sibling::div/input", "value"), employeeID);


    }


    @AfterClass
    public void afterClass() {
        driver.quit();

    }

    private BasePage basePage = BasePage.getBasePage();
    String firstName, lastName, emailAddress, password, employeeID;

}