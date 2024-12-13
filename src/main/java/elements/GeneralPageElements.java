package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GeneralPageElements {
    public static final SelenideElement
            generalTitle = $("div.col-md-12 h1.component-title"),
            firstNameInputField = $("#FirstName"),
            lastNameInputField = $("#LastName"),
            phoneNumberInputField = $("#Phone"),
            faxNumberInputField = $("#Fax"),
            savePersonalDetailsBtn = $("#save_button"),
            cancelPersonalDetailsBtn = $("#cancel_button"),
            successMessage = $(".alert-success"),
            closeButton = successMessage.$("button.close"),
            currentPasswordInputField = $("#cur_password"),
            newPasswordInputField = $("#new_password"),
            reEnterPasswordInputField = $("#new2_password");

}
