package pages.mystore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;


public class Login extends Base {

    @FindBy(name="email")
    WebElement email;
    @FindBy(name="password")
    WebElement password;
    public Login(WebDriver driver){
        super(driver);
        URL = "https://djangogreatkart.com/accounts/login/";
        initElements(this);
        this.visit();
    }

    private void setEmail(String emailText){
        performWaitForElement(email);
        email.sendKeys(emailText);
    }

    private void setPassword(String passwordText){
        performWaitForElement(password);
        password.sendKeys(passwordText);
    }

    private void enterToLogin(){
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

    public MyAccount loginChaining(String email,String password){
        this.setEmail(email);
        this.setPassword(password);
        this.enterToLogin();
        return new MyAccount(driver);
    }

}