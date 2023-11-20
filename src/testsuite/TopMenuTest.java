package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowserForSetUp(baseUrl);
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully() throws InterruptedException {

        driver.findElement(By.partialLinkText("Computers")).click();
        String expectedLink = "Computers";
        WebElement actualTestElement1 = driver.findElement(By.xpath("//h1"));
        String actualLink = actualTestElement1.getText();
        Assert.assertEquals("failed to click on - 'Computers' link", expectedLink, actualLink);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() throws InterruptedException {

        driver.findElement(By.linkText("Electronics")).click();
        String expectedLink = "Electronics";
        WebElement actualTestElement2 = driver.findElement(By.xpath("//h1"));
        String actualLink = actualTestElement2.getText();
        Assert.assertEquals("failed to click on - 'Electronics' link", expectedLink, actualLink);
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully() throws InterruptedException {

        driver.findElement(By.linkText("Apparel")).click();
        Thread.sleep(5000);
        String expectedLink = "Apparel";
        WebElement actualTestElement3 = driver.findElement(By.xpath("//h1"));
        String actualLink = actualTestElement3.getText();
        Assert.assertEquals("failed to click on - 'Apparel' link", expectedLink, actualLink);
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() throws InterruptedException {

        driver.findElement(By.linkText("Digital downloads")).click();
        Thread.sleep(5000);
        String expectedLink = "Digital downloads";
        WebElement actualTestElement4 = driver.findElement(By.xpath("//h1"));
        String actualLink = actualTestElement4.getText();
        Assert.assertEquals("failed to click on - 'Digital downloads' link", expectedLink, actualLink);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully() throws InterruptedException {
        driver.findElement(By.linkText("Books")).click();
        Thread.sleep(5000);
        String expectedLink = "Books";
        WebElement actualTestElement5 = driver.findElement(By.xpath("//h1"));
        String actualLink = actualTestElement5.getText();
        Assert.assertEquals("failed to click on - 'Books' link", expectedLink, actualLink);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() throws InterruptedException {
        driver.findElement(By.linkText("Jewelry")).click();
        Thread.sleep(5000);
        String expectedLink = "Jewelry";
        WebElement actualTestElement6 = driver.findElement(By.xpath("//h1"));
        String actualLink = actualTestElement6.getText();
        Assert.assertEquals("failed to click on - 'Jewelry' link", expectedLink, actualLink);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() throws InterruptedException {
        driver.findElement(By.linkText("Gift Cards")).click();
        Thread.sleep(5000);
        String expectedLink = "Gift Cards";
        WebElement actualTestElement7 = driver.findElement(By.xpath("//h1"));
        String actualLink = actualTestElement7.getText();
        Assert.assertEquals("failed to click on - 'Gift Cards' link", expectedLink, actualLink);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
