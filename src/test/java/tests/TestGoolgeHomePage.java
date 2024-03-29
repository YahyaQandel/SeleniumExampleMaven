package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
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
import java.io.IOException;
import java.time.Duration;


import static org.junit.Assert.*;
public class TestGoolgeHomePage {
	    private static final String GOOGLE_TEST_URL = "https://www.google.com/?hl=en";
	    private WebDriver driver;

	    @Before
	    public void prepare() {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
			chromeOptions.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(chromeOptions);
	        driver.get(GOOGLE_TEST_URL);
	    }

	    @Test
	    public void useGoogleSearchBox(){
			// start of action
	    	WebElement searchInputField = waitForElementToBeVisible(By.name("q"));
	    	searchInputField.sendKeys("Test Example By selenium");
	    	waitForElementToBeVisible(By.name("btnK")).click();
	    	String currentPageUrl = driver.getCurrentUrl();
			// end of action
			// start of assertion
			assertTrue(currentPageUrl.contains("https://www.google.com/search?"));
	    	assertTrue(currentPageUrl.contains("q=Test+Example+By+selenium"));
	    	assertEquals(driver.getTitle(),"Test Example By selenium - Google Search");
			// end of assertion
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
