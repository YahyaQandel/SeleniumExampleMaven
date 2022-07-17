package pages.mystore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;


public class Login extends Base {

    @FindBy(id="email")
    WebElement email;
    @FindBy(id="passwd")
    WebElement password;
    public Login(WebDriver driver){
        super(driver);
        URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        initElements(this);
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


    /**
     * This POM method will be exposed in test case to log in  the application
     * @param email: user registered email
     * @param password: user registered password
     */

    public void login(String email,String password){
        this.setEmail(email);
        this.setPassword(password);
        this.enterToLogin();
    }

}