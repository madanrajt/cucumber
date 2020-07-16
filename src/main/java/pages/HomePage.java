package pages;

import objects.HomePageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends HomePageObjects {

    public HomePage(RemoteWebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);

    }

    public HomePage loggedIn(){
        checkVisibility(brand);
        return this;

    }


}
