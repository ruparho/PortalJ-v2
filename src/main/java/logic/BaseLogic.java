package logic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.LoginPageElements;
import elements.MainPageElements;
import io.qameta.allure.Step;
import utils.Const;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static logic.MainPageLogic.acceptCookie;
import static logic.MainPageLogic.closeTour;
import static org.openqa.selenium.devtools.v115.page.Page.close;

public abstract class BaseLogic {
    public Const vVar = new Const();
    @Step
    public static void login(String username, String password) {
        LoginPageElements.usernameInput.val(username);
        LoginPageElements.passwordInput.val(password);
        LoginPageElements.loginButton.click();
        MainPageElements.loadingBlocking.shouldNotBe(Condition.visible, Duration.ofSeconds(10));
        Selenide.sleep(Const.NORMAL_SLEEP);
        closeTour();
        acceptCookie();
    }

    public static void logout() {
        MainPageElements.myAccount.hover();
        MainPageElements.logoutLink.shouldBe(visible).shouldBe(enabled);
        MainPageElements.logoutLink.click();
    }

    public static void goHome() {
        MainPageElements.mainLogo.click();
        Selenide.sleep(Const.SHORT_SLEEP);
    }

    public static void switchToTheAppCheckAndReturn(String windowName, SelenideElement appFrameName) {
        // Get current window
        String initialWindowHandle = getWebDriver().getWindowHandle();
        // Switch to the another window
        switchTo().window(windowName);
        // check, then close and back
        appFrameName.shouldBe(visible);
        close();
        switchTo().window(initialWindowHandle);
    }
}
