package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowserForSetUp(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        String expectedText = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText();

        Assert.assertEquals("Not redirected to login page", expectedText, actualText);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("prime1234@gmail.com");
        driver.findElement(By.name("Password")).sendKeys("Prime123");
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

        String logOutLink = "Log out";
        //WebElement logOutLink1 = driver.findElement(By.linkText("Log out"));
        WebElement logOutLink1 = driver.findElement(By.xpath("//a[text()='Log out']"));
        //logOutLink.click();

        String expectedLogOutMessage = logOutLink1.getText();
        Assert.assertEquals(logOutLink, expectedLogOutMessage);
    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // find the email field and type the email field
        WebElement emailfield = driver.findElement(By.name("Email"));
        emailfield.sendKeys("Prim123@gmail.com");
        Thread.sleep(5000);

        // find the password field and type the password
        driver.findElement(By.id("Password")).sendKeys("Prim123");
        Thread.sleep(5000);

        // find the login button and click
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        Thread.sleep(5000);
        // find the errorMessage element
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Test case pass", expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
