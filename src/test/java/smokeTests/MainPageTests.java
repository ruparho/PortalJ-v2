package smokeTests;


import com.codeborne.selenide.Selenide;
import logic.MainPageLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static logic.BaseLogic.login;

public class MainPageTests extends BaseTests {
    public static MainPageLogic logic;

    @BeforeEach
    public void beforeTest() {
        logic = new MainPageLogic();
        Selenide.open("");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        login(vVar.USERNAME, vVar.PASSWORD);
    }

    @Test
    public void test_01_faxLinkVerification() {
        logic.faxLinkVerification();
    }

    @Test
    public void test_02_webmailLinkVerification() {
        logic.webmailLinkVerification();
    }

    @Test
    public void test_03_supportVerification() {
        logic.supportAndFooterVerification();
    }

    @Test
    public void test_04_quickAccessVerification() {
        logic.quickAccessVerification();
    }

    @Test
    public void test_05_recentlyUsedAppsVerification() {
        logic.recentlyUsedAppsVerification();
    }

    @Test
    public void test_06_partnerSpaceSlideWidgetVerification() {
        logic.partnerSpaceSlideWidgetVerification();
    }

    @Test
    public void test_07_takeTourVerification() {
        logic.takeTourVerification();
    }

    @AfterEach
    public void afterTest() {
        getWebDriver().close();
    }


}
