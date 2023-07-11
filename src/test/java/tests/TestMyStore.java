package tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMyStore {

    private static final String MYSTORE_URL = "https://djangogreatkart.com/accounts/login/";
    private WebDriver driver;
    private String accountEmail = "yahya.qandel@gmail.com";
    private String accountPassword = "VDdReTVFIWE0UCEhCg";
    @Before
    public void prepare()  {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get(MYSTORE_URL);
    }
    @Test
    public void testAccountLogin(){
            // write your tests here
    }


    private WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
