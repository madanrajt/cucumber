package driver.capabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

class OptionsManager {

  static ChromeOptions getChromeOptions() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--ignore-certificate-errors");
    return options;
  }

  static FirefoxOptions getFirefoxOptions() {
    WebDriverManager.firefoxdriver().setup();
    FirefoxOptions options = new FirefoxOptions();
    FirefoxProfile profile = new FirefoxProfile();
    options.setCapability(FirefoxDriver.PROFILE, profile);
    return options;
  }
}
