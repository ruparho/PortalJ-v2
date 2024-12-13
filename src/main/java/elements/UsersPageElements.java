package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class UsersPageElements {
    public static final SelenideElement
            cancelServiceWidget = $("#cancelservicewidget");
    public static final SelenideElement returnToServicesButtonFromCancelWidget = $(".returnToServiceBurtton");
    public static final SelenideElement serviceDropdown = $(".portal-select[data-portal-select='Services']");
    public static final SelenideElement backToServicesButton = $("input[data-action='returnToServices']");
    public static final SelenideElement createAccountTitle = $("div.col-md-9.col-xs-9 h1.component-title");
    public static final SelenideElement userListingTitle = $("div.col-md-12 h1.component-title");
    public static final SelenideElement addButton = $(By.id("usermanagerAddUserButton"));
    public static final SelenideElement feedbackButton = $("#feedback-button");
    public static final SelenideElement usersTable = $("div.col-md-12 table");
    public static final SelenideElement accountInformationText = $(".panel-heading");
    public static final SelenideElement//  shouldHave(Condition.text("Account Information")),
            accountEnabledText = $x("//span[@data-title-on='Account enabled']");
    public static final SelenideElement accountEnabledCheckbox = $("label:contains(Account enabled) + div.portal-checkbox-toggle-wrapper");
    public static final SelenideElement usernameEmailText = $("label[for='username']");
    public static final SelenideElement usernameEmailInput = $("input[name='username']");
    public static final SelenideElement passwordText = $("label[for='password']");
    public static final SelenideElement passwordInput = $("input[name='password']");
    public static final SelenideElement firstNameText = $("label[for='firstName']");
    public static final SelenideElement firstNameInput = $("input[name='firstName']");
    public static final SelenideElement lastNameText = $("label[for='lastName']");
    public static final SelenideElement lastNameInput = $("input[name='lastName']");
    public static final SelenideElement accessLevelText = $x("//label[text()='Access Level']");
    public static final SelenideElement administratorCheckbox = $x("//label[@class='noTextSelect']//span[text()='Administrator']");
    public static final SelenideElement createUsersCheckbox = $($x("//label[@class='noTextSelect']//span[text()='Create Users']"));
    public static final SelenideElement disabledText = $x("//span[@class='title nowrap textEllipsis' and @data-title-on='Enabled' and @data-title-off='Disabled']");
    public static final SelenideElement disabledCheckbox = $("label:contains(Disabled) + div.portal-checkbox-toggle-wrapper");
    public static final SelenideElement firtsDomain = $x("//*[@id='applet_usermanager']/form/div[1]/div/div[2]/div[5]/div/div[2]/div/fieldset/div[2]/label/input");
    public static final SelenideElement emailErrorIcon = $("span[data-toggle='tooltip'][data-original-title='Please enter a valid email address.'][class='form-control-feedback'][role='field-icon']");
    public static final SelenideElement firstNameErrorIcon = $x("//span[@class='form-control-feedback' and @data-toggle='tooltip' and @role='field-icon' and @data-original-title='Please enter correct data.']");
    public static final SelenideElement passwordErrorIcon = $("span.form-control-feedback[role='field-icon'][data-original-title^='The Password field must be']");
    public static final SelenideElement lastNameErrorIcon = $("span.form-control-feedback[data-toggle='tooltip'][role='field-icon'][data-original-title='Please enter correct data.']");
    public static final SelenideElement tooltipUsers = $("div.tooltip-inner");
    public static final SelenideElement tooltipFirstName = $("div.tooltip-inner:contains(This field may contain letters, dashes and spaces. Length should be from 1 to 255.)");
    public static final SelenideElement tooltipLastName = $("div.tooltip-inner:contains(This field may contain letters, dashes and spaces. Length should be from 1 to 255.)");
    public static final SelenideElement tooltipPassword = $("div.tooltip-inner:contains(The Password field must be 8-32 characters long. It must contain at least 1 upper case character(s), 1 lower case character(s), 2 digit(s) and 1 special character(s) ~!@#*^<>-$%&()+=_?/{}')");
    public static final SelenideElement emailValidIcon = $("div.form-group.has-success.has-feedback span.form-control-feedback[role='field-icon']");
    public static final SelenideElement firstNameValidIcon = $("div.form-group.has-success.has-feedback input#firstName ~ span.form-control-feedback[role='field-icon']");
    public static final SelenideElement lastNameValidIcon = $("div.form-group.has-success.has-feedback input#lastName ~ span.form-control-feedback[role='field-icon']");
    public static final SelenideElement passwordValidIcon = $("div.password.has-success.has-feedback input#password + span.form-control-feedback");
    public static final SelenideElement passwordDots = $("input[type='password']");
    public static final SelenideElement passwordShow = $("input[type='text']");
    public static final SelenideElement generatePasswordButtonSecond = $("button.btn[data-original-title='Generate password']");
    public static final SelenideElement generatePasswordButton = $("span.input-group-addon[data-original-title='Generate password']");
    public static final SelenideElement showPasswordButtonSecond = $("button.btn[data-original-title='Show password']");
    public static final SelenideElement showPasswordButton = $("span.input-group-addon[data-original-title='Show password']");
    public static final SelenideElement cancelButton = $("input[type='button'][name='reset'][class='btn btn-default'][value='Cancel']");
    public static final SelenideElement addUserButton = $("[type='submit']");
    public static final SelenideElement noUsersMessage = $("h2");
    public static final SelenideElement userRowElement = $$("td").find(Condition.text("qatest"));
    public static final SelenideElement userHoweredColor = $(".portal-form");
    public static final SelenideElement editUserButton = $("[data-action='editUser']");
    public static final SelenideElement disabledUsernameInputElement = $("#username[readonly]");
    public static final SelenideElement accountEnabled = $(".onoffswitch .icon");
    public static final SelenideElement accountDisabled = $(".title.nowrap.textEllipsis");
    public static final SelenideElement deleteUserIcon = $("span.fa.fa-lg.fa-fw.fa-trash.pointer[data-toggle='tooltip'][data-action='deleteUser'][title='Delete User']");
    public static final SelenideElement deleteUserIconSecond = $("span.fa.fa-lg.fa-fw.fa-trash.pointer[data-toggle='tooltip'][data-action='deleteUser']");
    public static final SelenideElement deleteButton = $$(".modal-footer button").findBy(Condition.attribute("data-bb-handler", "delete_btn"));
    public static final SelenideElement cancelDeletion = $$(".modal-footer button").findBy(Condition.attribute("data-bb-handler", "cancel"));
    public static final SelenideElement closeButton = $("button.bootbox-close-button");
    public static final SelenideElement deleteTitle = $("h4.modal-title");
    public static final SelenideElement deleteConfirmationText = $(withText("Are you sure you want to delete this user?"));
    public static final SelenideElement deleteUserTitle = $("div.modal-content h4.modal-title");
    public static final SelenideElement domainCheckboxes = $(".title");
    public static final SelenideElement emptyTable = $("*[text()='No users are available.']");
    public static final SelenideElement ftpUsernameInput = $("input[name='FtpUsername']");
    public static final SelenideElement ftpUserPermission = $("input[type='radio']");
    public static final SelenideElement//accessCheckboxes = (SelenideElement) $$("[role='menuitemcheckbox']"),
            emailUsernameInput = $("input[name='EmailUsername']");
    public static final SelenideElement emailUserPermission = $("input[type='radio']");
    public static final SelenideElement domainTab = $("[data-permission-tab='domain']");
    public static final SelenideElement ftpTab = $("[data-permission-tab='ftp']");
    public static final SelenideElement emailTab = $("[data-permission-tab='email']");
    public static final SelenideElement userForm = $("#UsermanagerForm");

}
