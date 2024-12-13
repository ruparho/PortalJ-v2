package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageElements {

    /*** Login Page Elements ***/
    public static final SelenideElement
            loginForm = $(byId("LoginForm")),
            usernameLabelTop = $(byId("login_username")),
            tipIconUsername = $("#tipIconUsername"),
            usernameInput = $("input[name=login]"),
            passwordInput = $("input[name=password]"),
            rememberCheckbox = $("#remember"),
            forgotPasswordLink = $(byId("forgotPassLink")),
            languageSelect = $(".portal-select[data-portal-select=ForcedLanguage]"),
            loginButton = $("#buttonLogin"),
            messageBoxError = $(byId("messageBox")).find(".error");


    /*** Forgot Password Page Elements ***/
    public static final SelenideElement
            userOrEmailContainer = $(byId("userOrEmailContainer")),
            forgotPasswordText = userOrEmailContainer.$(".forgot_top"),
            noWorriesText = userOrEmailContainer.$(".no_worries"),
            usernameText = userOrEmailContainer.$(".label_top"),
            userOrEmailInput = userOrEmailContainer.$(byId("userOrEmail")),
            resetPasswordButton = $(byId("buttonReset")),
            backToLoginLink = $(byId("doCancel")),
            resetInstructionsMessage = $(byId("messageBox"));

    /*** Forgot Password Error Dialog ***/
    public static SelenideElement
            dialogContent = $(byId("dialogContent")),
            dialogTitle = $(byId("dialog_title")),
            dialogText = $(byId("dialog_text")),
            dialogButtonOk = $(byId("dialog_button_ok"));
}
