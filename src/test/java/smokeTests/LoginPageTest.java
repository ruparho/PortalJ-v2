package smokeTests;

import com.codeborne.selenide.Selenide;
import logic.LoginPageLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class LoginPageTest extends BaseTests {
    public static LoginPageLogic logic;

    @BeforeEach
    public void beforeTest() {
        logic = new LoginPageLogic();
        Selenide.open("");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void test_01_forgotPasswordLoginPageFunctionalityCheck() {
        logic.forgotPasswordVerification();
    }

    @Test
    public void test_02_checkboxLoginPageVerification() {
        logic.checkboxLoginPageVerification();
    }

    @Test
    public void test_03_loginPageFunctionalityVerification(){
        logic.loginPageFunctionalityVerification();
    }
}
