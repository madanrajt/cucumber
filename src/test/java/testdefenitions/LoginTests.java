package testdefenitions;

import actions.LoginAction;
import cucumber.api.java.en.Given;

public class LoginTests {

    private LoginAction loginAction;

    public LoginTests() {
        loginAction = new LoginAction();
    }

    @Given("^the user enters username and otp for Login$")
    public void the_user_enters_username_and_otp_for_Login() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("::inside step defenition::");
        loginAction.loginHRM();


    }


}
