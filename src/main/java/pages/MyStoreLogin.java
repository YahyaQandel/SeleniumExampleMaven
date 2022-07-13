package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyStoreLogin  {

    WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(id="email")
    WebElement email;
    @FindBy(id="passwd")
    WebElement password;
    private final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    public MyStoreLogin(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
        this.driver.get(URL);
    }

    public void setEmail(String emailText){
        performWaitForElement(email);
        email.sendKeys(emailText);
    }

    public void setPassword(String passwordText){
        performWaitForElement(password);
        password.sendKeys(passwordText);
    }

    public void enterToLogin(){
        performWaitForElement(password);
        password.sendKeys(Keys.RETURN);
    }

    private void performWaitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * This POM method will be exposed in test case to login in the application
     * @param email
     * @param password
     * @return
     */

    public void login(String email,String password){
        this.setEmail(email);
        this.setPassword(password);
        this.enterToLogin();
    }

}