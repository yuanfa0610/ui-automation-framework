import com.company.product.test.automation.ui.framework.actions.BasePageComponentImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

public class WebDriverIOHomePage extends BasePageComponentImpl<WebDriverIOHomePage> {


    private final WebDriver driver;
    private boolean isPageLoaded;

    private static final String PAGE_URL_TEXT = "webdriver.io";

    public WebDriverIOHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        this.isPageLoaded = true;
        System.out.println("Loading page: " + this.driver.getCurrentUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        String url = this.driver.getCurrentUrl();
        Assert.assertTrue(this.isPageLoaded && url.contains(PAGE_URL_TEXT),
                "WebDriver home page not loaded");
        System.out.println("WebDriver Home page loaded");
    }
}
