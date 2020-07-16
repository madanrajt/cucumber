package objects;

import driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects extends DriverFactory {

    @FindBy(id = "welcome")
    public WebElement brand;
}
