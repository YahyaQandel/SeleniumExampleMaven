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
        driver = new ChromeDriver(chromeOptions);
        driver.get(_URL);
    }

    @Test
    public void assertUserWinsWhenARowIsComplete() {
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


    @Test
    public void assertGoBackToCertainMoveWithValidHistory() {
        HashMap<Integer, HashMap<Integer, String>> boardState = new HashMap<>();
        this.playOn(0);
        this.updateBoardState(boardState, 0);
        this.playOn(3);
        this.updateBoardState(boardState, 1);
        this.playOn(8);
        this.updateBoardState(boardState, 2);
        List<WebElement> goToMoveBtns = this.waitForElementsToBeVisible(By.id("go-to-move-btn"));
        WebElement goToFirstMove = goToMoveBtns.get(0);
        WebElement goToSecondMove = goToMoveBtns.get(1);
        WebElement goToThirdMove = goToMoveBtns.get(2);
        // assert board state in first move
        goToFirstMove.click();
        assertEquals(boardState.get(0),this.getCurrentBoardState());
        // assert board state in second move
        goToSecondMove.click();
        assertEquals(boardState.get(1),this.getCurrentBoardState());
        // assert board state in third move
        goToThirdMove.click();
        assertEquals(boardState.get(2),this.getCurrentBoardState());
    }

    private void playOn(int cellIndex) {
        WebElement cell = this.waitForElementToBeVisible(By.id(String.format("square-%d", cellIndex)));
        cell.click();
    }

    private String getBoardCell(int cellIndex) {
        WebElement cell = this.waitForElementToBeVisible(By.id(String.format("square-%d", cellIndex)));
        return cell.getText().toString();
    }

    private void updateBoardState(HashMap<Integer, HashMap<Integer, String>>currentBoard, int move) {
        HashMap<Integer, String> board = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            board.put(i, this.getBoardCell(i));
        }
        currentBoard.put(move, board);
    }
    private HashMap<Integer, String> getCurrentBoardState() {
        HashMap<Integer, String> board = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            board.put(i, this.getBoardCell(i));
        }
        return board;
    }

    private WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(this.driver, 60);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }

    private List<WebElement> waitForElementsToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(this.driver, 60);
        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }
    @After
    public void teardown() {
        this.driver.quit();
    }

}
