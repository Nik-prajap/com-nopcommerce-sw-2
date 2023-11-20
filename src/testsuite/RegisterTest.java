package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setup() {
        openBrowserForSetUp(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {

        String registerLink = "Register";
        driver.findElement(By.className("ico-register")).click();
        Assert.assertEquals("Register", "Register");
        driver.navigate().to(baseUrl);
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {

        driver.findElement(By.className("ico-register")).click();                        // click on Register link
        driver.findElement(By.id("gender-male")).click();                                // Select Male gender radio button
        driver.findElement(By.name("FirstName")).sendKeys("Prime");         // Enter First name
        driver.findElement(By.id("LastName")).sendKeys("Testing");          // Enter Last Name

        // Select Day for date of birth (DOB)
        WebElement dropDownDay = driver.findElement(By.name("DateOfBirthDay"));
        Select ddd = new Select(dropDownDay);
        ddd.selectByVisibleText("1");
        Thread.sleep(2500);

        // Select Month for DOB from dropdown menu using object creation
        WebElement dropDownMonth = driver.findElement(By.name("DateOfBirthMonth"));
        Select ddm = new Select(dropDownMonth);
        ddm.selectByVisibleText("July");
        Thread.sleep(2500);

        // Select Year for DOB from dropdown menu using object creation.
        WebElement dropDownYear = driver.findElement(By.name("DateOfBirthYear"));
        Select ddy = new Select(dropDownYear);
        ddy.selectByVisibleText("1990");

        // Enter email to emailField
        driver.findElement(By.id("Email")).sendKeys("PrimeTesting4@gmail.com");

        // Enter Password to password field
        driver.findElement(By.id("Password")).sendKeys("Prime123");

        // Enter Confirm password to Confirm Password Field
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Prime123");

        // Click on Register Button
        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']")).click();

        Assert.assertEquals("Your registration completed", "Your registration completed");

        driver.navigate().to(baseUrl);
        System.out.println(driver.getTitle());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
