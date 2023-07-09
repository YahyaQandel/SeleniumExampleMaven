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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestTicTacToe {
    private static final String _URL = "http://tictactoe.automationtesting.tech";
    private WebDriver driver;
    @Before
    public void prepare()  {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.get(_URL);
    }
    @Test
    public void assertUserWinsWhenARowIsComplete(){
        /* Board
        -------------
        | 0 | 1 | 2 |
        | 3 | 4 | 5 |
        | 6 | 7 | 8 |
        -------------
        */
        this.playOn(0);
        this.playOn(3);
        this.playOn(1);
        this.playOn(4);
        this.playOn(2);
        WebElement winnerLabel = this.waitForElementToBeVisible(By.id("winner"));
        assertTrue(winnerLabel.getText().contains("X"));
    }
    private void playOn(int squareIndex){
        WebElement square = this.waitForElementToBeVisible(By.id(String.format("square-%d",squareIndex)));
        square.click();
    }
//    public void assertGoBackToCertainMoveWithValidHistory() {
//
//    }
    private WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(this.driver, 60);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }
    @After
    public void teardown(){
        this.driver.quit();
    }

}
