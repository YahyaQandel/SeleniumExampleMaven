package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    WebDriver driver;
    private final WebDriverWait wait;
    protected String URL;
    protected Base(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
    }
    protected void initElements(Object child){
        PageFactory.initElements(driver, child);
        this.driver.get(URL);
    }
    protected void performWaitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
