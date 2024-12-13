package logic;

import com.codeborne.selenide.Selenide;
import elements.*;
import utils.Const;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static logic.MainPageLogic.closeTour;

public class MyAccountDropdownLogic extends BaseLogic {
    private Const vVar = new Const();


    public void myAccountLinksVerification() {
        // 1. Click on "Users" link from the drop down.
        closeTour();

        Selenide.sleep(Const.VERY_VERY_LONG_SLEEP);
        if (MainPageElements.tourCloseButton.isDisplayed()) {
            MainPageElements.tourCloseButton.click();
        }
        MainPageElements.myAccount.hover();
        MainPageElements.usersButton.click();
        Selenide.sleep(Const.NORMAL_SLEEP);

        // Result: Users section should be opened.
        UsersPageElements.userForm.shouldBe(visible);

        // 2. Click on "Services" link from the drop-down.
        MainPageElements.myAccount.hover();
        MainPageElements.servicesButton.click();
        Selenide.sleep(Const.NORMAL_SLEEP);

        // Result: Services section should be opened.
        ServicesPageElements.servicesForm.shouldBe(visible);

        // 3. Click "Invoices" link from the drop-down.
        MainPageElements.myAccount.hover();
        if (MainPageElements.invoicesButton.exists()) {
            MainPageElements.invoicesButton.click();
            Selenide.sleep(Const.NORMAL_SLEEP);

            // Result: Invoices section should be opened.
            InvoicesPageElements.invoicesForm.shouldBe(visible);
        }


        // 4. Click "Advanced Tools" link from the drop-down.
        MainPageElements.myAccount.hover();
        if (MainPageElements.advancedToolsButton.exists()) {
            MainPageElements.advancedToolsButton.click();
            Selenide.sleep(Const.NORMAL_SLEEP);

            // Result: Advanced tools section should be opened.
            AdvancedToolsElements.advancedToolsForm.shouldBe(visible);
        }
        // 5. Click "General" link from the drop-down.
        MainPageElements.myAccount.hover();
        if (MainPageElements.generalButton.exists()) {
            MainPageElements.generalButton.click();
            Selenide.sleep(Const.NORMAL_SLEEP);

            // Result: General section should be opened.
            MainPageElements.generalForm.shouldBe(visible);
        }
        // 6. Click "Payments"link from the drop-down.
        MainPageElements.myAccount.hover();
        if (MainPageElements.paymentsButton1.exists()) {
            MainPageElements.paymentsButton1.click();
            Selenide.sleep(Const.VERY_LONG_SLEEP);

            // Result: Payments section should be opened.
            PaymentsPageElements.paymentsForm.shouldBe(visible);
        }
        // 7. Click "Payments"(Braintree)  link from the drop-down.
        MainPageElements.myAccount.hover();
        if (MainPageElements.paymentsButton2.exists()) {
            MainPageElements.paymentsButton2.click();
            Selenide.sleep(Const.NORMAL_SLEEP);

            // Result: Payments(Braintree)  section should be opened.
            PaymentsPageElements.paymentsBraintreeForm.shouldBe(visible);
        }
        // 8. Click "Logout" link from the drop-down.
        MainPageElements.myAccount.hover();
        MainPageElements.logoutLink.click();
        // Result: Login Page should be opened.
        LoginPageElements.loginButton.shouldBe(visible);
    }

    public void editAccountDetails() {
        // Pause to ensure elements are loaded
        Selenide.sleep(Const.SHORT_SLEEP);
        // Wait until the loading spinner is invisible
        MainPageElements.loadingBlocking.shouldNotBe(visible);
        closeTour();

        // Click the "My Account" dropdown button
        MainPageElements.myAccount.hover();

        // Wait for the dropdown view to be visible
        MainPageElements.generalButton.shouldBe(visible);

        // Click on the (General)
        MainPageElements.generalButton.shouldBe(visible).click();

        // Pause to ensure the elements load
        Selenide.sleep(Const.SHORT_SLEEP);

        // Assert the title text is "General"
        GeneralPageElements.generalTitle.shouldHave(text("General"));

        // Set personal details
        String firstName1 = "AQA";
        $(GeneralPageElements.firstNameInputField).clear();
        $(GeneralPageElements.firstNameInputField).sendKeys(firstName1);

        String lastName = "TEST";
        $(GeneralPageElements.lastNameInputField).clear();
        $(GeneralPageElements.lastNameInputField).sendKeys(lastName);

        String phoneNumber = generateRandomPhoneNumber();
        $(GeneralPageElements.phoneNumberInputField).clear();
        $(GeneralPageElements.phoneNumberInputField).sendKeys(phoneNumber);

        String faxNumber = generateRandomFaxNumber();
        $(GeneralPageElements.faxNumberInputField).clear();
        $(GeneralPageElements.faxNumberInputField).sendKeys(faxNumber);

        Selenide.sleep(Const.SHORT_SLEEP);

        // Click the save button for personal details
        $(GeneralPageElements.savePersonalDetailsBtn).click();

        // Pause to ensure save operation completes
        Selenide.sleep(Const.LONG_SLEEP);

        // Assert the success message
        GeneralPageElements.successMessage.shouldHave(text("Personal Details successfully updated!"));

        // Assert the updated values
        $(GeneralPageElements.firstNameInputField).shouldHave(value(firstName1));
        $(GeneralPageElements.lastNameInputField).shouldHave(value(lastName));
        $(GeneralPageElements.phoneNumberInputField).shouldHave(value(phoneNumber));
        $(GeneralPageElements.faxNumberInputField).shouldHave(value(faxNumber));

        // Update the password
        $(GeneralPageElements.currentPasswordInputField).clear();
        $(GeneralPageElements.currentPasswordInputField).setValue(vVar.PASSWORD);

        $(GeneralPageElements.newPasswordInputField).clear();
        $(GeneralPageElements.newPasswordInputField).setValue(Const.NEW_PASSWORD);

        $(GeneralPageElements.reEnterPasswordInputField).clear();
        $(GeneralPageElements.reEnterPasswordInputField).setValue(Const.NEW_PASSWORD);

        // Click the save button for password
        $(GeneralPageElements.savePersonalDetailsBtn).click();

        // Pause to ensure save operation completes
        Selenide.sleep(Const.NORMAL_SLEEP);
        // Assert the success message for password update
        GeneralPageElements.successMessage.shouldHave(text("Password successfully updated!"));
        Selenide.sleep(Const.NORMAL_SLEEP);

        // Logout and login with the new password
        logout();
        login(vVar.USERNAME, Const.NEW_PASSWORD);

        // Revert the password to the old one
        Selenide.sleep(Const.SHORT_SLEEP);
        // Wait until the loading spinner is invisible
        MainPageElements.loadingBlocking.shouldNotBe(visible);
        closeTour();

        // Click the "My Account" dropdown button
        MainPageElements.myAccount.hover();

        // Wait for the dropdown view to be visible
        MainPageElements.generalButton.shouldBe(visible);

        // Click on the (General)
        MainPageElements.generalButton.shouldBe(visible).click();

        $(GeneralPageElements.currentPasswordInputField).clear();
        $(GeneralPageElements.currentPasswordInputField).setValue(Const.NEW_PASSWORD);

        $(GeneralPageElements.newPasswordInputField).clear();
        $(GeneralPageElements.newPasswordInputField).setValue(vVar.PASSWORD);

        $(GeneralPageElements.reEnterPasswordInputField).clear();
        $(GeneralPageElements.reEnterPasswordInputField).setValue(vVar.PASSWORD);

        // Click the save button for password
        $(GeneralPageElements.savePersonalDetailsBtn).click();

        // Pause to ensure save operation completes
        Selenide.sleep(Const.NORMAL_SLEEP);
        // Assert the success message for password update
        GeneralPageElements.successMessage.shouldHave(text("Password successfully updated!"));

        // Logout and login with the original password
        logout();

        login(vVar.USERNAME, vVar.PASSWORD);
    }

    private String generateRandomPhoneNumber() {
        double randomizer = 2020 + Math.random() * 80;
        return "+1.61490" + (int) randomizer;
    }

    private String generateRandomFaxNumber() {
        double randomizer = 1020 + Math.random() * 80;
        return "123456" + (int) randomizer;
    }

}

