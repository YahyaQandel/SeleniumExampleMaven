package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount {

    WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(className="page-heading")
    WebElement myProfileIconInlineText;
    @FindBy(className="account")
    WebElement AccountHeadingTitle;
    private final String URL = "http://automationpractice.com/index.php?controller=my-account";
    public MyAccount(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
        this.driver.get(URL);
    }

    public String getAccountNameTitle(){
        wait.until(ExpectedConditions.visibilityOf(AccountHeadingTitle));
        return AccountHeadingTitle.getText();
    }
    public String getPageHeadingTitle(){
        wait.until(ExpectedConditions.visibilityOf(myProfileIconInlineText));
        return myProfileIconInlineText.getText();
    }
}