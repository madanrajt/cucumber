package pages;

import objects.LoginPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends LoginPageObjects {

    public LoginPage(RemoteWebDriver driver) {
        System.out.println("::inside Login page::");
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);

    }

    public LoginPage credentials(){
        checkVisibility(username);
        checkVisibility(password);
        username.sendKeys(obj.getProperty("name"));
        password.sendKeys(obj.getProperty("pass"));
        return this;

        }

        public HomePage signIn(){
        checkVisibility(loginButton);
        loginButton.click();
        return new HomePage(driver);

        }


}
