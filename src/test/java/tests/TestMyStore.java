package tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMyStore {

    private String accountEmail = System.getenv("ACCOUNT_EMAIL");
    private String accountPassword = System.getenv("ACCOUNT_PASSWORD");
    private static final String MYSTORE_URL = "https://djangogreatkart.com/accounts/login/";
    private WebDriver driver;

    @Before
    public void prepare(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.get(MYSTORE_URL);
    }
    @Test
    public void testAccountLogin() {
        loginToAccount();
        assertUserDetailsExistsInPage();
    }

    private void assertUserDetailsExistsInPage() {
        WebElement accountNumberTitle = waitForElementToBeVisible(By.className("card-header"));
        String AccountHeadingTitle = accountNumberTitle.getText();
        assertTrue(AccountHeadingTitle.contains("Logged in as: Test User"));
    }

    private void loginToAccount() {
        WebElement loginNumberField = waitForElementToBeVisible(By.name("email"));
        loginNumberField.sendKeys(accountEmail);
        WebElement loginPasswordField = waitForElementToBeVisible(By.name("password"));
        loginPasswordField.sendKeys(accountPassword);
        loginPasswordField.sendKeys(Keys.RETURN);
    }


    private WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
