package smokeTests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.MutableCapabilities;
import utils.Const;

import java.util.HashMap;

public abstract class BaseTests {
    public Const vVar = new Const();

    static {
        Configuration.browser = Const.BROWSER;
        if (Configuration.browser.equalsIgnoreCase("safari")) {
            // Set up BrowserStack remote configuration for Safari using W3C capabilities
            Configuration.remote = "https://browserstack_VIMvRz:13Yz6WkfFwMixvAgc547@hub.browserstack.com/wd/hub";

            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("bstack:options", new HashMap<String, Object>() {{
                put("os", "OS X");
                put("osVersion", "Big Sur");
                put("sessionName", "Selenide Safari Test on BrowserStack"); // Test name
                put("buildName", "Selenide-BrowserStack-Build"); // Build name
            }});

            capabilities.setCapability("browserName", "safari");
            capabilities.setCapability("browserVersion", "latest");

            Configuration.browserCapabilities = capabilities;
        } else {
            // Local configuration for Chrome and Firefox
            Configuration.remote = null; // Ensure it runs locally
        }
        Configuration.headless = true;
        Configuration.fastSetValue = true;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
    {
        Configuration.baseUrl = vVar.BASE_URL;
    }
}
