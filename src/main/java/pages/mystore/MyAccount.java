package pages.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;

public class MyAccount extends Base {

    @FindBy(className="card-header")
    WebElement AccountHeadingTitle;
    public MyAccount(WebDriver driver){
        super(driver);
        URL = "https://djangogreatkart.com/accounts/";
        initElements(this);
    }

    public String getAccountHeadingTitle(){
        performWaitForElement(AccountHeadingTitle);
        return AccountHeadingTitle.getText();
    }
}