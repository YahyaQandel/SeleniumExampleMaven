package pages.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;

public class MyAccount extends Base {

    @FindBy(className="page-heading")
    WebElement myProfileIconInlineText;
    @FindBy(className="account")
    WebElement AccountHeadingTitle;
    public MyAccount(WebDriver driver){
        super(driver);
        URL = "http://automationpractice.com/index.php?controller=my-account";
        initElements(this);
    }

    public String getAccountNameTitle(){
        return AccountHeadingTitle.getText();
    }
    public String getPageHeadingTitle(){
        return myProfileIconInlineText.getText();
    }
}