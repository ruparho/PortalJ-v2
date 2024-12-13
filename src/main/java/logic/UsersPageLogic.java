package logic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.MainPageElements;
import elements.UsersPageElements;
import org.openqa.selenium.By;
import utils.Const;

import java.util.Random;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static logic.MainPageLogic.closeTour;

public class UsersPageLogic extends BaseLogic {
    String randomNumber = generateRandomNumber(8);
    String user = "qatest-cheetah-critical-" + randomNumber + "@test.com";
    String email = "newCreatedEmail";
    private Const vVar = new Const();


    public void addUserVerification() {
        // Step 1. Proceed to 'Users' section.
        MainPageElements.myAccount.hover();
        MainPageElements.usersButton.click();
        pressDeleteUserButtonUntilNotPresent();
        UsersPageElements.userRowElement.shouldNotBe(visible);
        observeUsersPage();
        closeTour();

        if ($(By.xpath("//*[@id=\"lhnHocInvite\"]/div/div[2]/div[1]")).exists()) {
            $(By.xpath("//*[@id=\"lhnHocInvite\"]/div/div[2]/div[1]")).click();
        }

        // Step 2. Click on 'Add User' button.
        // line that should be deleted after the resolving the issue PORTAL-5115 in FF
        Selenide.sleep(Const.SHORT_SLEEP);
        Selenide.refresh();
        Selenide.sleep(Const.SHORT_SLEEP);
        Selenide.actions().moveByOffset(1000, 1000).click();
        Selenide.sleep(Const.SHORT_SLEEP);
        /////////////////////////////////////////////////////////////
        UsersPageElements.addButton.click();

        // Step 3. Observe page for GUI, grammar, typo issues.
        observeAddUserPage();

        // Step 4. Observe tooltips on the page.
        observeTooltips();

        // Step 5. Check 'Username' field.
        checkEmail();

        // Step 6. Check 'First name' field.
        checkFirstName();

        // Step 7. Check 'Last name' field.
        checkLastName();

        // Step 8. Check 'Password' field.
        checkPassword();

        // Step 9. Click on 'Generate password' button.
        generatePassword();

        // Step 10. Click on 'Show Password' button.
        showPassword();

        // Step 11. Fill all mandatory fields and click 'Cancel' button.
        fillAllFields();
        Selenide.sleep(Const.NORMAL_SLEEP);
        UsersPageElements.cancelButton.click();
        UsersPageElements.usernameEmailInput.shouldBe(hidden);

        // Step 12. Fill all mandatory fields and click 'Add User'.
        addUser();

        // Step 13. Check User Listing section
        checkUserInTable();
    }


    public void editUserOptionsVerification() {
        // Step 1-2. Go to My Account Users and create a User
        MainPageElements.myAccount.hover();
        MainPageElements.usersButton.click();
        Selenide.sleep(Const.LONG_SLEEP);
        pressDeleteUserButtonUntilNotPresent();
        UsersPageElements.userRowElement.shouldNotBe(visible);
        observeUsersPage();
        closeTour();

        if ($(By.xpath("//*[@id=\"lhnHocInvite\"]/div/div[2]/div[1]")).exists()) {
            $(By.xpath("//*[@id=\"lhnHocInvite\"]/div/div[2]/div[1]")).click();
        }
        addUser();

        // Step 3. Hover over any user from the 'User listing'.
        UsersPageElements.userRowElement.hover();
        checkTableHighlight();

        // Step 4. Click on Cog icon to edit user.
        UsersPageElements.editUserButton.shouldBe(Condition.visible).click();

        // Step 5-6. Observe page for GUI, grammar, typo issues.
        Selenide.sleep(Const.NORMAL_SLEEP);
        observeEditUserPage();

        // Step 7. Check 'Username' field.
        UsersPageElements.disabledUsernameInputElement.shouldBe(visible);

        // Step 8. Check 'First Name' field.
        checkFirstName();

        // Step 9. Check 'Last Name' field.
        checkLastName();

        // Step 10. Check 'Password' field.
        checkPassword();

        // Step 11.Check 'Access' options.
        UsersPageElements.administratorCheckbox.shouldBe(visible).click();

        // Step 12. Click on 'Status' toggle.
        UsersPageElements.accountEnabled.click();
        UsersPageElements.accountDisabled.text().equals("Account disabled");

        // Step 13. Click on Cancel button.
        UsersPageElements.cancelButton.shouldBe(visible).click();
        Selenide.sleep(Const.NORMAL_SLEEP);
        UsersPageElements.editUserButton.shouldBe(visible).click();
        UsersPageElements.accountEnabled.shouldBe(visible);


        // Step 14. Click on 'Save' button'
        UsersPageElements.firstNameInput.shouldBe(visible).clear();
        UsersPageElements.firstNameInput.sendKeys("Changed");
        UsersPageElements.addUserButton.shouldBe(visible).click();
        Selenide.sleep(Const.NORMAL_SLEEP);
        // TODO add check for the changed user
    }

    public void deleteUserOptionsVerification() {
        // Step 1-2. Go to My Account Users and create a User
        Selenide.sleep(Const.NORMAL_SLEEP);
        closeTour();

        MainPageElements.myAccount.hover();
        MainPageElements.usersButton.click();
        Selenide.sleep(Const.LONG_SLEEP);
        pressDeleteUserButtonUntilNotPresent();
        UsersPageElements.userRowElement.shouldNotBe(visible);
        observeUsersPage();
        if ($(By.xpath("//*[@id=\"lhnHocInvite\"]/div/div[2]/div[1]")).exists()) {
            $(By.xpath("//*[@id=\"lhnHocInvite\"]/div/div[2]/div[1]")).click();
        }
        UsersPageElements.userListingTitle.click();
        addUser();
        Selenide.sleep(Const.NORMAL_SLEEP);

        // 2. Click on 'Delete' button on any user.
        UsersPageElements.deleteUserIcon.shouldBe(visible).click();
        checkDeleteModalWindow();

        // 3. Click on 'Cancel' button.
        UsersPageElements.cancelDeletion.shouldBe(visible).click();
        checkDeleteModalWindowAbsence();

        // Wait for the second delete user icon to be visible and click
        UsersPageElements.deleteUserIconSecond.shouldBe(visible).click();

        // 4. Click on 'Close' button.
        UsersPageElements.closeButton.shouldBe(visible).click();
        checkDeleteModalWindowAbsence();

        // Wait for the second delete user icon to be visible and click
        UsersPageElements.deleteUserIconSecond.shouldBe(visible).click();

        // 5. Click on 'Delete' button.
        Selenide.sleep(Const.SHORT_SLEEP);
        UsersPageElements.deleteButton.shouldBe(visible).click();
        checkDeleteModalWindowAbsence();

    }


    private void checkUserInTable() {
        UsersPageElements.userRowElement.shouldBe(visible);
    }


    private void observeTooltips() {// Typing '1' into various input fields
        Selenide.$(UsersPageElements.usernameEmailInput).shouldBe(visible).setValue("1");
        Selenide.$(UsersPageElements.passwordInput).shouldBe(visible).setValue("1");
        Selenide.$(UsersPageElements.firstNameInput).shouldBe(visible).setValue("1");
        Selenide.$(UsersPageElements.lastNameInput).shouldBe(visible).setValue("1");

        // Clicking error icons and observing tooltips
        Selenide.$(UsersPageElements.emailErrorIcon).shouldBe(visible).click();
        Selenide.$(UsersPageElements.tooltipUsers).shouldHave(Condition.text("Please enter a valid email address."));
        Selenide.sleep(Const.SHORT_SLEEP);

        // Uncomment if needed
//        Selenide.$(UsersPageElements.passwordErrorIcon).shouldBe(Condition.visible).click();
//        Selenide.$(UsersPageElements.tooltipUsers).shouldHave(Condition.text("The Password field must be 8-32 characters long. It must contain at least 1 upper case character(s), 1 lower case character(s), 1 digit(s) and 1 special character(s) `~!@#$%^&*()-_=+[{]}|;:'&quot;,<.>/?"));
//        Selenide.sleep(Const.SHORT_SLEEP);

        Selenide.$(UsersPageElements.firstNameErrorIcon).shouldBe(visible).click();
        Selenide.$(UsersPageElements.tooltipUsers).shouldHave(Condition.text("Please enter correct data."));
        Selenide.sleep(Const.SHORT_SLEEP);

        Selenide.$(UsersPageElements.lastNameErrorIcon).shouldBe(visible).click();
        Selenide.$(UsersPageElements.tooltipUsers).shouldHave(Condition.text("Please enter correct data."));
        Selenide.sleep(Const.SHORT_SLEEP); // Sleep for a short duration
    }


    public void pressDeleteUserButtonUntilNotPresent() {
        int maxAttempts = 10;
        int attempt = 0;

        while (UsersPageElements.deleteUserIcon.isDisplayed() && attempt < maxAttempts) {
            attempt++;
            MainPageElements.loadingBlocking.should(Condition.disappear);
            UsersPageElements.deleteUserIcon.click();
            UsersPageElements.deleteButton.click();
        }

        attempt = 0;

        while (UsersPageElements.deleteUserIconSecond.isDisplayed() && attempt < maxAttempts) {
            attempt++;
            UsersPageElements.deleteUserIconSecond.click();
            UsersPageElements.deleteButton.click();
        }

        if (UsersPageElements.deleteUserIcon.isDisplayed() || UsersPageElements.deleteUserIconSecond.isDisplayed()) {
            throw new IllegalStateException("Unable to delete all users within the maximum allowed attempts.");
        }
    }

    public void observeUsersPage() {
        UsersPageElements.usersTable.shouldBe(visible);
        UsersPageElements.addButton.shouldBe(visible);
        UsersPageElements.userListingTitle.shouldBe(visible);
        UsersPageElements.createAccountTitle.shouldBe(visible);
    }

    public void observeAddUserPage() {
        UsersPageElements.accountInformationText.shouldBe(visible);
        UsersPageElements.accountEnabledText.shouldBe(visible);
        UsersPageElements.usernameEmailText.shouldBe(visible);
        UsersPageElements.usernameEmailInput.shouldBe(visible);
        UsersPageElements.passwordText.shouldBe(visible);
        UsersPageElements.passwordInput.shouldBe(visible);
        UsersPageElements.firstNameText.shouldBe(visible);
        UsersPageElements.firstNameInput.shouldBe(visible);
        UsersPageElements.lastNameText.shouldBe(visible);
        UsersPageElements.lastNameInput.shouldBe(visible);
        UsersPageElements.accessLevelText.shouldBe(visible);
        UsersPageElements.administratorCheckbox.shouldBe(visible);
        UsersPageElements.createUsersCheckbox.shouldBe(visible);
        UsersPageElements.emailTab.shouldBe(visible);
        UsersPageElements.disabledText.shouldBe(visible);
        UsersPageElements.disabledText.shouldBe(visible);
    }

    public void checkEmail() {
        // Clear the input field, enter an invalid email, and wait for the error icon
        enterEmailAndCheck("invalidemail");

        // Clear the input field, enter multiple emails separated by comma, and wait for the error icon
        enterEmailAndCheck("test1@example.com,test2@example.com");

        // Clear the input field, enter a short string, and wait for the error icon
        enterEmailAndCheck("12345");

        // Clear the input field, enter an email with invalid format, and wait for the error icon
        enterEmailAndCheck("test.email%@asd.com");

        // Clear the input field, enter a short email, and wait for the error icon
        enterEmailAndCheck("a@a.c");

        // Clear the input field, enter a valid email, wait for the valid icon, and clear the input field
        enterEmailAndCheck("valid@valid.com");
    }

    private void enterEmailAndCheck(String email) {
        Selenide.$(UsersPageElements.usernameEmailInput).shouldBe(visible).clear();
        Selenide.$(UsersPageElements.usernameEmailInput).shouldBe(visible).sendKeys(email);

        // Additional wait for valid icon if the email is valid
        if (email.equals("valid@valid.com")) {
            Selenide.$(UsersPageElements.emailValidIcon).shouldBe(visible);
            Selenide.$(UsersPageElements.usernameEmailInput).shouldBe(visible).clear();
        } else {
            Selenide.$(UsersPageElements.emailErrorIcon).shouldBe(visible);
        }
    }

    public void checkFirstName() {
        // Enter invalid first name and check for error icon
        checkFirstNameInput("123@", UsersPageElements.firstNameErrorIcon);
        checkFirstNameInput("PASHA#", UsersPageElements.firstNameErrorIcon);
        checkFirstNameInput("abc123", UsersPageElements.firstNameErrorIcon);

        // Enter valid first names and check for valid icon
        checkFirstNameInput("こんにちは", UsersPageElements.firstNameValidIcon);
        checkFirstNameInput("Firstname", UsersPageElements.firstNameValidIcon);
    }

    private void checkFirstNameInput(String input, SelenideElement icon) {
        UsersPageElements.firstNameInput.shouldBe(visible).clear();
        UsersPageElements.firstNameInput.shouldBe(visible).setValue(input);
        icon.shouldBe(visible);
    }

    public void checkLastName() {
        // Enter invalid last name and check for error icon
        checkInputAndIcon("123@", UsersPageElements.lastNameErrorIcon);
        checkInputAndIcon("PASHA#", UsersPageElements.lastNameErrorIcon);
        checkInputAndIcon("abc123", UsersPageElements.lastNameErrorIcon);

        // Enter valid last names and check for valid icon
        checkInputAndIcon("こんにちは", UsersPageElements.lastNameValidIcon);
        checkInputAndIcon("Lastname", UsersPageElements.lastNameValidIcon);
    }

    private void checkInputAndIcon(String input, SelenideElement icon) {
        UsersPageElements.lastNameInput.shouldBe(visible).clear();
        UsersPageElements.lastNameInput.shouldBe(visible).sendKeys(input);
        icon.shouldBe(visible);
    }

    public void checkPassword() {
        enterPassword("123@");
        UsersPageElements.passwordErrorIcon.shouldBe(visible);
    }

    public void generatePassword() {
        UsersPageElements.passwordInput.shouldBe(visible);
        UsersPageElements.generatePasswordButton.shouldBe(visible).click();
        UsersPageElements.passwordValidIcon.shouldBe(visible);
    }

    private void enterPassword(String password) {
        UsersPageElements.passwordInput.shouldBe(visible).clear();
        UsersPageElements.passwordInput.shouldBe(visible).sendKeys(password);
    }

    public void showPassword() {
        UsersPageElements.showPasswordButton.click();
        UsersPageElements.passwordShow.shouldBe(visible);
    }

    public void fillAllFields() {
        // Clear and fill username/email input field
        UsersPageElements.usernameEmailInput.shouldBe(visible).clear();
        UsersPageElements.usernameEmailInput.shouldBe(visible).setValue(user);

        // Clear and fill first name input field
        UsersPageElements.firstNameInput.shouldBe(visible).clear();
        UsersPageElements.firstNameInput.shouldBe(visible).setValue("Firstname");

        // Clear and fill last name input field
        UsersPageElements.lastNameInput.shouldBe(visible).clear();
        UsersPageElements.lastNameInput.shouldBe(visible).setValue("Lastname");

        // Clear and fill password input field
        UsersPageElements.passwordInput.shouldBe(visible).clear();
        UsersPageElements.passwordInput.shouldBe(visible).setValue(vVar.PASSWORD);
    }

    public static String generateRandomNumber(int symbolCount) {
        StringBuilder sb = new StringBuilder(symbolCount);
        Random random = new Random();

        for (int i = 0; i < symbolCount; i++) {
            int randomDigit = random.nextInt(10); // Generates a random digit from 0 to 9
            sb.append(randomDigit);
        }

        return sb.toString();
    }

    public void addUser() {
        UsersPageElements.addButton.shouldBe(Condition.visible).click();
        fillAllFields();
        UsersPageElements.administratorCheckbox.shouldBe(Condition.visible).click();
        UsersPageElements.addUserButton.shouldBe(Condition.visible).click();
        Selenide.sleep(Const.LONG_SLEEP);
    }

    private void checkTableHighlight() {
        // Retrieve the color value of the element
        String colorValue = UsersPageElements.userHoweredColor.getCssValue("color");

        // Define the expected color value
        String expectedColorValue = "rgba(129, 129, 129, 1)"; // Using rgba format

        // Check if the color value matches the expected value
        if (colorValue.equals(expectedColorValue)) {
            System.out.println("Portal form color is equal to " + expectedColorValue);
        } else {
            System.out.println("Portal form color is not equal to " + expectedColorValue);
        }
    }

    public void observeEditUserPage() {
        UsersPageElements.accountInformationText.shouldBe(visible);
        UsersPageElements.accountEnabledText.shouldBe(visible);
        UsersPageElements.usernameEmailText.shouldBe(visible);
        UsersPageElements.usernameEmailInput.shouldBe(visible);
        UsersPageElements.passwordInput.shouldBe(visible);
        UsersPageElements.firstNameInput.shouldBe(visible);
        UsersPageElements.lastNameInput.shouldBe(visible);
        UsersPageElements.accessLevelText.shouldBe(visible);
        UsersPageElements.administratorCheckbox.shouldBe(visible);
        UsersPageElements.createUsersCheckbox.shouldBe(visible);
        UsersPageElements.domainTab.shouldBe(visible);
        UsersPageElements.ftpTab.shouldBe(visible);
        UsersPageElements.emailTab.shouldBe(visible);
        UsersPageElements.disabledText.shouldBe(visible);
    }

    private static void checkDeleteModalWindow() {
        // Wait for the elements in the delete modal window to become visible
        UsersPageElements.cancelDeletion.shouldBe(visible);
        UsersPageElements.closeButton.shouldBe(visible);
        UsersPageElements.deleteButton.shouldBe(visible);
        UsersPageElements.deleteTitle.shouldBe(visible);
    }

    private static void checkDeleteModalWindowAbsence() {
        // Wait for the delete user title to become invisible
        UsersPageElements.deleteUserTitle.shouldBe(hidden);
    }
}

