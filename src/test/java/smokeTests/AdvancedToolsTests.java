package smokeTests;

import com.codeborne.selenide.Selenide;
import logic.AdvancedToolsLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static logic.BaseLogic.login;

public class AdvancedToolsTests extends BaseTests {
    public static AdvancedToolsLogic logic;

    @BeforeEach
    public void beforeTest() {
        logic = new AdvancedToolsLogic();
        Selenide.open("");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        login(vVar.USERNAME, vVar.PASSWORD);
    }

    @Test
    public void test_01_advancedToolsFunctionalityVerification() {
        logic.advancedToolsFunctionalityVerification();
    }

    @Test
    public void test_02_appsLaunchVerification() {
        logic.appsLaunchVerification();
    }

    @AfterEach
    public void afterTest() {
        getWebDriver().close();
    }
}
