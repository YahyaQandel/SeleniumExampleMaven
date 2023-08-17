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
    private static final String accountEmail = "test@automationclass.com";
    private static final String accountPassword = "T7Qy5E$Bt!a4P!!";

    @Before
    public void prepare() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void testAccountLogin() {
        Login myStoreLoginPage = new Login(driver);
        myStoreLoginPage.login(accountEmail,accountPassword);
        MyAccount myAccountPage = new MyAccount(driver);
        assertTrue(myAccountPage.getAccountNameTitle().contains("Test User"));
        assertEquals(myAccountPage.getPageHeadingTitle(),ACCOUNT_ICON_HEADER);
    }


    @After
    public void teardown(){
        driver.quit();
    }

}
