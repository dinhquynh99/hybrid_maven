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

public class Level_02_BasePage_III extends BasePage {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();

        firstName = "Peter";
        lastName = "Crouch";
        emailAddress = "Peter" + new Random().nextInt(9999) + "@gmail.com";
        password = "Testing111###";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void Employee_01_NewEmployee() {
        openPageURL(driver, "http://localhost:88/orangehrm/");

        senkeyToElement(driver, "//input[@name='username']", "automationfc");
        senkeyToElement(driver, "//input[@name='password']", "Auto222$$$");
        clickToElement(driver, "//button[contain(@class,'orangehrm-login-button')]");

        Assert.assertTrue(isloadingIconDisappear(driver));

        Assert.assertTrue(isElementDisplay(driver, "//h6[text()='Dashbroard']"));

        clickToElement(driver, "//span[text()='PIM']/parent::a");
        Assert.assertTrue(isloadingIconDisappear(driver));

        Assert.assertTrue(isElementDisplay(driver, "//h6[text()='PIM']"));

        clickToElement(driver, "//a[text()='Add Employee']");
        Assert.assertTrue(isloadingIconDisappear(driver));

        senkeyToElement(driver, "//input[@name='firstName']", firstName);
        senkeyToElement(driver, "//input[@name='lastname']", lastName);

        employeeID = getElementDomProperty(driver, "//label[text()='Employee Id']/parent::div/following-sibling::div/input", "value");
        clickToElement(driver, "//p[text()='Create Login Details']/following-sibling::div//span");
        sleepInSecond(2);

        senkeyToElement(driver, "//label[text()='Username']/parent::div/following-sibling::div/input", emailAddress);
        senkeyToElement(driver, "//label[text()='Password']/parent::div/following-sibling::div/input", password);
        senkeyToElement(driver, "//label[text()='Confirm Password']/parent::div/following-sibling::div/input", password);

        clickToElement(driver, "//button[contains(string(),'Save')]");
        sleepInSecond(2);

        Assert.assertTrue(isElementDisplay(driver,"//p[text()='Successfully Saved']"));
        Assert.assertTrue(isloadingIconDisappear(driver));

       Assert.assertEquals(getElementDomProperty(driver, "//input[@name='firstName']", "value"), firstName);;
       Assert.assertEquals(getElementDomProperty(driver, "//input[@name='lastName']", "value"), lastName);;
       Assert.assertEquals(getElementDomProperty(driver, "//label[text()='Employee Id']/parent::div/following-sibling::div/input", "value"), employeeID);


    }


    @AfterClass
    public void afterClass() {
        driver.quit();

    }

    String firstName, lastName, emailAddress, password, employeeID;

}