package smokeTests;

import com.codeborne.selenide.Selenide;
import logic.UsersPageLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static logic.BaseLogic.login;

public class UsersPageTests extends BaseTests {
    public static UsersPageLogic logic;

    @BeforeEach
    public void beforeTest() {
        logic = new UsersPageLogic();
        Selenide.open("");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        login(vVar.USERNAME, vVar.PASSWORD);
    }

    @Test
    public void test_01_addUserVerification() {
        logic.addUserVerification();
    }


    @Test
    public void test_02_editUserVerification() {
        logic.editUserOptionsVerification();
    }

    @Test
    public void test_03_deleteUserVerification() {
        logic.deleteUserOptionsVerification();
    }


    @AfterEach
    public void afterTest() {
        getWebDriver().close();
    }
}
