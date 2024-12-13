package logic;

import com.codeborne.selenide.Selenide;
import elements.MainPageElements;
import utils.Const;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.devtools.v85.page.Page.close;


public class MainPageLogic extends BaseLogic {



    public void faxLinkVerification() {
        closeTour();
        //Click on Fax icon
        MainPageElements.faxIcon.click();
        //Result: Correct page should be opened
        switchTo().window(1);
        Selenide.sleep(Const.VERY_VERY_LONG_SLEEP);
        MainPageElements.faxLogo.shouldBe(visible);
        MainPageElements.faxLoginForm.shouldBe(visible);
    }

    public void webmailLinkVerification() {
        closeTour();
        //Click on Webmail icon
        MainPageElements.webmailIcon.click();
        //Result: Correct page should be opened
        switchTo().window(1);
        Selenide.sleep(20000);
        MainPageElements.webmailLogo.shouldBe(visible);
        MainPageElements.webmailLoginForm.shouldBe(visible);
    }

    public void supportAndFooterVerification() {
        closeTour();
        //hover over the 'Support' icon
        MainPageElements.supprotIcon.hover();
        //Result: Support overlay should be expanded
        Selenide.sleep(Const.SHORT_SLEEP);
        MainPageElements.supportOverlay.shouldBe(visible);

        //Hover the mouse pointed over a different location
        MainPageElements.faxIcon.hover();
        //Support overlay should be collapsed
        Selenide.sleep(Const.SHORT_SLEEP);
        MainPageElements.supportOverlay.shouldNotBe(visible);

        //Check footer existence
        MainPageElements.footer.shouldBe(visible);
    }

    public void quickAccessVerification() {
        closeTour();
        //Click the 'Advanced Tools' link
        MainPageElements.advancedToolsLink.click();
        //Result: Advanced Tools should be launched
        MainPageElements.advancedToolsPage.shouldBe(visible);

        // Return to the Main Page
        goHome();

        //Click the 'Advanced Tools' link
        MainPageElements.createWebsiteLink.click();
        //Result: Advanced Tools should be launched
        MainPageElements.websitesPage.shouldBe(visible);

        // Return to the Main Page
        goHome();

        //Click the 'Add an Email' link
        MainPageElements.addAnEmailLink.click();
        //Result: EasyMail Setup should be launched
        switchTo().window("Mailsetup");
        MainPageElements.mailManagerFrame.shouldBe(visible);
        close();
    }

    public void recentlyUsedAppsVerification() {
        closeTour();
        // Check the absence of the recently used apps block
        MainPageElements.recentlyUsedAppsBlock.shouldNotBe(visible);

        //Click the 'Add an Email' link
        MainPageElements.addAnEmailLink.click();

        //Result: EasyMail Setup should be launched
        switchToTheAppCheckAndReturn("Mailsetup", MainPageElements.mailManagerFrame);

        // Return to the Main Page and check the presence of the recently used apps block
        MainPageElements.recentlyUsedAppsBlock.shouldBe(visible);

        // Launch any other app
        MainPageElements.advancedToolsLink.click();
        MainPageElements.fileManagerLaunchButton.click();
        switchToTheAppCheckAndReturn("Filemanager", MainPageElements.fileManagerFrame);

        // Return to the Main Page and check the presence of the two apps in recently used apps block
        goHome();
        MainPageElements.fileManagerQuickLaunch.shouldBe(visible);
        MainPageElements.mailManagerQuickLaunch.shouldBe(visible);

        // Launch several applications from the Recently Used Apps section, The applications should be launched properly
        MainPageElements.fileManagerQuickLaunch.shouldBe(visible).click();
        switchToTheAppCheckAndReturn("Filemanager", MainPageElements.fileManagerFrame);
        goHome();

        MainPageElements.mailManagerQuickLaunch.shouldBe(visible).click();
        switchToTheAppCheckAndReturn("Mailsetup", MainPageElements.mailManagerFrame);
        goHome();

        // Clear browser cookies and Clear browser local storage and re-login to the Portal
        clearBrowserLocalStorage();
        clearBrowserCookies();
        refresh();
        login(vVar.USERNAME, vVar.PASSWORD);

        // Result: The Recently Used Applications widget should be absent
        MainPageElements.recentlyUsedAppsBlock.shouldNotBe(visible);
    }

    public void partnerSpaceSlideWidgetVerification() {
        closeTour();
        MainPageElements.slideWidget.shouldBe(visible);
    }

    public void takeTourVerification() {
        // Verify block's content
        checkTourContent();

        // Click 'Take a Tour' button
        MainPageElements.tourStartTourButton.click();

        // Result: First step should appear, all the information should be accurate
        checkStepsTourContent("Quick Access");

        // Click Next button
        MainPageElements.tourNextButton.click();

        // Result: Second step should appear, all the information should be accurate
        checkStepsTourContent("Account Information");

        // Click Back Button
        MainPageElements.tourPrevButton.click();
        Selenide.sleep(Const.LONG_SLEEP);

        // Result: First step should be opened
        checkStepsTourContent("Quick Access");

        // Click 'Close' icon
        MainPageElements.tourCloseIcon.click();

        // Result: Section should be closed
        checkTourAbsence();

        //Do not complete the tour, logout from Portal and login again
        logout();
        login(vVar.USERNAME, vVar.PASSWORD);

        //Result: 'Take a tour' overlay should be displayed again
        checkTourContent();

        // Click 'Don't show this again', logout from Portal and login again
        MainPageElements.tourDontShowAgainCheckbox.click();
        MainPageElements.tourCloseButton.click();
        logout();
        login(vVar.USERNAME, vVar.PASSWORD);

        // Result: 'Take a tour' overlay should not be displayed again
        checkTourAbsence();

        // Hover over support icon on top bar and click 'Take a Tour' button.
        MainPageElements.supprotIcon.hover();
        MainPageElements.takeTourButton.click();

        // Result: 'Take a tour' button should be opened properly
        checkTourContent();

        // Complete the tour
        MainPageElements.tourStartTourButton.click();
        checkStepsTourContent("Quick Access");
        MainPageElements.tourNextButton.click();
        checkStepsTourContent("Account Information");
        MainPageElements.tourNextButton.click();
        checkStepsTourContent("Support");
        MainPageElements.tourNextButton.click();
        checkStepsTourContent("Online Presence Builder");
        MainPageElements.tourNextButton.click();
        checkStepsTourContent("Website & Domain Information");
        MainPageElements.tourNextButton.click();
        checkStepsTourContent("Service Management");
        MainPageElements.tourNextButton.click();
        checkStepsTourContent("Advanced Tools");
        MainPageElements.tourFinishButton.click();

        checkTourAbsence();
    }


    public static void checkTourContent() {
        MainPageElements.tourCloseButton.shouldBe(visible);
        MainPageElements.tourHeader.shouldBe(visible);
        MainPageElements.tourBody.shouldBe(visible);
        MainPageElements.tourNoThanksButton.shouldBe(visible);
        MainPageElements.tourDontShowAgainCheckbox.shouldBe(visible);
        MainPageElements.tourStartTourButton.shouldBe(visible);
    }

    public static void checkStepsTourContent(String messageTittle) {
        MainPageElements.tourMessageTitle.shouldBe(visible).shouldHave(text(messageTittle));
        MainPageElements.tourMessageContent.shouldBe(visible);
        MainPageElements.tourNextButton.shouldBe(visible);
        MainPageElements.dimmerElement.has(cssValue("display", "none"));
        if (messageTittle == "Quick Access") {
            MainPageElements.tourPrevButton.shouldNotBe(visible);
        } else {
            MainPageElements.tourPrevButton.shouldBe(visible);
        }
    }

    public static void checkTourAbsence() {
        MainPageElements.dimmerElement.has(cssValue("display", "none"));
        MainPageElements.tourMessage.shouldNotBe(visible);
        MainPageElements.tourMessageTitle.shouldNotBe(visible);
        MainPageElements.tourMessageContent.shouldNotBe(visible);
        MainPageElements.tourNextButton.shouldNotBe(visible);
    }

    public static void closeTour() {
        if (MainPageElements.tourCloseButton.isDisplayed()) {
            MainPageElements.tourDontShowAgainCheckbox.click();
            MainPageElements.tourCloseButton.click();
        }
    }

    public static void acceptCookie() {
        if (MainPageElements.acceptCookies.isDisplayed()) {
            MainPageElements.acceptCookies.click();
        }
    }

}
