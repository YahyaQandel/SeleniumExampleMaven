package tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.mystore.MyAccount;
import pages.mystore.Login;

public class TestMyStore {

    public static final String ACCOUNT_ICON_HEADER = "MY ACCOUNT";
    private WebDriver driver;
    private String accountEmail = "yahya.qandel@gmail.com";
    private String accountPassword = "VDdReTVFIWE0UCEhCg";

    @Before
    public void prepare() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void testAccountLogin() {
        // you can navigate by your own to the next page
        Login myStoreLoginPage = new Login(driver);
        myStoreLoginPage.login(accountEmail,accountPassword);
        MyAccount myAccountPage = new MyAccount(driver);
        assertTrue(myAccountPage.getAccountHeadingTitle().contains("Test User"));
    }
    @Test
    public void testAccountLoginChaining() {
        // or use chaining
        Login myStoreLoginPage = new Login(driver);
        MyAccount myAccountPage = myStoreLoginPage.loginChaining(accountEmail,accountPassword);
        assertTrue(myAccountPage.getAccountHeadingTitle().contains("Test User"));

    }

    @After
    public void teardown(){
        driver.quit();
    }

}
