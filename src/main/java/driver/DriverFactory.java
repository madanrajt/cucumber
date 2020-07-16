package driver;


import driver.capabilities.CapabilityManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.apache.log4j.Logger.getLogger;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

@SuppressWarnings({"deprecation"})
public class DriverFactory {

  private static final int IMPLICIT_TIMEOUT = 20;
  private static final int PAGE_LOAD_TIMEOUT = 20;
  private static final int SCRIPT_TIMEOUT = 20;
  public static RemoteWebDriver driver;
  private static final String BROWSER = "chrome";
  private static final String APPLICATION_URL = "https://opensource-demo.orangehrmlive.com/";
  public static WebDriverWait wait;
  public static Properties obj;
  private static final String GRID_URL = null;
  private static CapabilityManager capabilityManager ;
  public static final String LOCAL = "LOCAL";
  private static final String ENVIRONMENT = "LOCAL";
  private static org.apache.log4j.Logger log = getLogger(DriverFactory.class);

  /* ############################ Property file Method ############################## */

  public void loadObject() {

    obj = new Properties();
    try {
      obj.load(new FileInputStream("./src/main/resources/config.properties"));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void unloadObject() {

    obj = null;
  }

  /* ############################ chrome to launch automatically ############################## */


  public void driverSet(String browser) {
    System.out.println("::comes inside driverSetUp method in DriverFactory::");

    if (browser.equalsIgnoreCase(BROWSER)) {
      System.out.println("::comes inside driver method::");
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    }

    driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS);
    driver.get(APPLICATION_URL);
    driver.manage().window().maximize();


  }
  /* ############################ chrome driver setup ############################## */


  public void driverSetUp() throws Exception {
    System.out.println("::inside driverSetUp in Factory::");
    if (LOCAL.equals(ENVIRONMENT)) {

      switch (BROWSER) {
        case CHROME:
          driver = new ChromeDriver(capabilityManager.getCapabilities(CHROME));
          System.out.println("::inside driverSetUp in Factory (switch case)::");
          break;
        case FIREFOX:
          driver = new FirefoxDriver(capabilityManager.getCapabilities(FIREFOX));
          break;
        default:
          throw new Exception(
                  "Invalid com.bhs.driver type " + BROWSER + " use chrome or firefox");
      }
    } else {
      try {

        driver = new RemoteWebDriver(new URL(GRID_URL), capabilityManager.getCapabilities(BROWSER));
      } catch (MalformedURLException e) {
      }
    }
    driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT, TimeUnit.SECONDS);
    driver.navigate().to(APPLICATION_URL);
  }

  /* ############################ checkVisibility of Element ############################## */

  public void checkVisibility(WebElement element) {
    wait = new WebDriverWait(driver, 15, 50);
    wait.until(ExpectedConditions.visibilityOf(element));
  }


  /* ############################ close Browser ############################## */

  public void driverTearDown() {
    log.info("*********** Closing browser ***********");
    driver.quit();
  }
}
