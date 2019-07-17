import com.company.product.test.automation.ui.framework.utils.AutomationConfiguration;
import com.company.product.test.automation.ui.framework.utils.WebDriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UIAutomationTest {

  private static RemoteWebDriver driver;

  public static void main (String args[]) {
    System.out.print("Testing UI Automation framework");

    try {

      AutomationConfiguration automationConfiguration = new AutomationConfiguration();
      automationConfiguration.setBrowserName("safari");
      automationConfiguration.setWebDriverPath("/Users/fangzhouyuan/Downloads");
      automationConfiguration.setImplicitWaitTime(5L);

      driver = WebDriverFactory.getWebDriver(automationConfiguration);

      WebDriverFactory.initializeWebDriver(automationConfiguration, driver);

      driver.get("https://webdriver.io/");

      WebDriverIOHomePage webDriverIOHomePage = new WebDriverIOHomePage(driver).get();

      System.out.println("Test ended");


    } catch (Exception e) {

    } finally {
      driver.quit();
    }

  }
}