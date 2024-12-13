package logic;


import com.codeborne.selenide.Selenide;
import elements.LoginPageElements;
import io.qameta.allure.Step;
import utils.Const;

import static com.codeborne.selenide.Condition.*;


public class LoginPageLogic extends BaseLogic{

    public void forgotPasswordVerification() {
        // 1. Click Forgot password link
        LoginPageElements.forgotPasswordLink.click();
        Selenide.sleep(Const.SHORT_SLEEP);

        // Step Result: Page with Email address/username field should appear
        checkForgotPasswordPage();

        // 2. Leave blank field and click 'Reset password' button
        LoginPageElements.resetPasswordButton.click();
        // Step result: Error Message should appear
        checkErrorMessageDialog();

        // 3. Fill Email address/username field with correct information
        LoginPageElements.userOrEmailInput.val(Const.VALID_EMAIL);

        // 4. Enter a non-existing/random username
        LoginPageElements.userOrEmailInput.clear();
        LoginPageElements.userOrEmailInput.val(Const.RANDOM_USERNAME);
        LoginPageElements.resetPasswordButton.click();

        // Step Result: Success message should appear: "Password reset instructions have been sent."
        LoginPageElements.resetInstructionsMessage.shouldBe(visible);
        LoginPageElements.backToLoginLink.click();

        // 5. Enter a valid username
        LoginPageElements.forgotPasswordLink.click();
        LoginPageElements.userOrEmailInput.val(Const.VALID_EMAIL);
        LoginPageElements.resetPasswordButton.click();

        // Step Result: Success message should appear: "Password reset instructions have been sent."
        LoginPageElements.resetInstructionsMessage.shouldBe(visible);

        // 6. Click 'Back to login' link
        LoginPageElements.backToLoginLink.click();

        // Login page should be displayed
        checkLoginPage();

        // TODO Steps 7-8-9 or not TODO
    }

    public void checkboxLoginPageVerification() {
        // 1. Check / uncheck remember me checkbox
        LoginPageElements.rememberCheckbox.click();
        LoginPageElements.rememberCheckbox.shouldNotBe(checked);
        LoginPageElements.rememberCheckbox.click();
        LoginPageElements.rememberCheckbox.shouldBe(checked);
    }

    public void loginPageFunctionalityVerification() {
        // 1. Enter invalid data to Username click 'Login' button
        LoginPageElements.usernameInput.val(Const.RANDOM_USERNAME);
        Selenide.sleep(Const.NORMAL_SLEEP);
        LoginPageElements.loginButton.click();
        // Result: Error message "Please enter username and password" should be visible
        LoginPageElements.messageBoxError.shouldBe(visible,have(text(Const.ENTER_USERNAME_AND_PASSWORD_ERROR)));

        // 2. Enter invalid data to Username and Password fields and click 'Login' button
        login(Const.RANDOM_USERNAME, Const.RANDOM_PASSWORD);
        // Result: Error message "Please enter username and password" should be visible
        LoginPageElements.messageBoxError.shouldBe(visible);

        // 3. Enter correct data to Username and Password fields
        login(vVar.USERNAME, vVar.PASSWORD);
    }


    @Step
        public static void checkLoginPage() {
        LoginPageElements.loginForm.shouldBe(visible);
        LoginPageElements.usernameInput.shouldBe(visible);
        LoginPageElements.passwordInput.shouldBe(visible);
        LoginPageElements.rememberCheckbox.shouldBe(visible);
        LoginPageElements.forgotPasswordLink.shouldBe(visible);
        LoginPageElements.languageSelect.shouldBe(visible);
        LoginPageElements.loginButton.shouldBe(visible);
        LoginPageElements.usernameLabelTop.shouldBe(visible);
        LoginPageElements.tipIconUsername.shouldBe(visible);
    }

    @Step
    public static void checkForgotPasswordPage() {
        LoginPageElements.forgotPasswordText.shouldBe(visible);
        LoginPageElements.noWorriesText.shouldBe(visible);
        LoginPageElements.usernameText.shouldBe(visible);
        LoginPageElements.userOrEmailInput.shouldBe(visible);
        LoginPageElements.resetPasswordButton.shouldBe(visible);
        LoginPageElements.backToLoginLink.shouldBe(visible);
    }

    @Step
    public static void checkErrorMessageDialog() {
        LoginPageElements.dialogContent.shouldBe(visible);
        LoginPageElements.dialogTitle.shouldBe(visible);
        LoginPageElements.dialogText.shouldBe(visible);
        LoginPageElements.dialogButtonOk.shouldBe(visible).click();
    }
}
