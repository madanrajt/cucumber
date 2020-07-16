import cucumber.api.CucumberOptions;
import driver.DriverFactory;
import org.testng.annotations.*;


@CucumberOptions(
        features = "src/test/java/features/HRMLogin.feature",
        glue = {"testdefenitions"},
        plugin = {"json:target/cucumber-report/cucumber.json"},
        monochrome = true)
public class CukesTestRunner {

    private DriverFactory driverFactory;

    public CukesTestRunner() {
        driverFactory = new DriverFactory();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("::inside setup::");
        driverFactory.driverSetUp();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("::inside tearDown::");
        driverFactory.driverTearDown();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("::inside load::");
        driverFactory.loadObject();

    }

    @AfterTest
    public void afterTest() {
        System.out.println("::inside unload::");
        driverFactory.unloadObject();
    }


}
