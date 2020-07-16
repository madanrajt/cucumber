package driver.capabilities;

import org.openqa.selenium.Capabilities;

import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class CapabilityManager {

  public Capabilities getCapabilities(String browser) {

    return FIREFOX.equals(browser)
        ? OptionsManager.getFirefoxOptions()
        : OptionsManager.getChromeOptions();
  }
}
