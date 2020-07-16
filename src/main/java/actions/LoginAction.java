package actions;

import driver.DriverFactory;
import pages.LoginPage;

public class LoginAction extends DriverFactory {

    public LoginPage loginPage=new LoginPage(driver);

    public void loginHRM(){

        loginPage.credentials().signIn().loggedIn();


}
}
