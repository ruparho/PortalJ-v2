package smokeTests;

import com.codeborne.selenide.Selenide;
import logic.ServicesPageLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static logic.BaseLogic.login;

public class ServicesPageTests extends BaseTests {
    public static ServicesPageLogic logic;

    @BeforeEach
    public void beforeTest() {
        logic = new ServicesPageLogic();
        Selenide.open("");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        login(vVar.USERNAME, vVar.PASSWORD);
    }

    @Test
    public void test_01_servicesVerification() {
        logic.servicesVerification();
    }

    @Test
    public void test_02_linksVerification() {
        logic.linksVerification();
    }

    @Test
    public void test_03_reassignDomainVerification() {
        logic.reassignLinkVerification();
    }

    @Test
    public void test_04_cancelServiceVerification() {
        logic.cancelServiceVerification();
    }

    @AfterEach
    public void afterTest() {
        getWebDriver().close();
    }
}
