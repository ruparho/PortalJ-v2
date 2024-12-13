package smokeTests;

import com.codeborne.selenide.Selenide;
import logic.MyAccountDropdownLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static logic.BaseLogic.login;

public class MyAccountDropdownTests extends BaseTests {
    public static MyAccountDropdownLogic logic;

    @BeforeEach
    public void beforeTest() {
        logic = new MyAccountDropdownLogic();
        Selenide.open("");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        login(vVar.USERNAME, vVar.PASSWORD);
    }

    @Test
    public void test_01_myAccountLinksVerification() {
        logic.myAccountLinksVerification();
    }

//    @Test
//    public void test_02_editAccountDetailsVerification() {
//        logic.editAccountDetails();
//    }

    @AfterEach
    public void afterTest() {
        getWebDriver().close();
    }
}
