package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestTicTacToe {
    private static final String _URL = "http://tictactoe.automationtesting.tech";
    private WebDriver driver;

    @Before
    public void prepare() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get(_URL);
    }

    @Ignore
    public void assertUserWinsWhenARowIsComplete() {
        /* Board
        -------------
        | 0 | 1 | 2 |
        | 3 | 4 | 5 |
        | 6 | 7 | 8 |
        -------------

        Winner
        -------------
        | x | x | x | => winner
        | . | . | . |
        | . | . | . |
        -------------
        */

    }


    @Ignore
    public void assertGoBackToCertainMoveWithValidHistory() {

    }

    private WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(60));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }

    private List<WebElement> waitForElementsToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(60));
        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }
    @After
    public void teardown() {
        this.driver.quit();
    }

}
