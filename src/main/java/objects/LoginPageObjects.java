package objects;

import driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects extends DriverFactory {

    @FindBy(id = "txtUsername")
    public WebElement username;

    @FindBy(id ="txtPassword" )
    public  WebElement password;

    @FindBy(id ="btnLogin" )
    public  WebElement loginButton;

}
