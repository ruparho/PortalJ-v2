package logic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import elements.AdvancedToolsElements;
import elements.MainPageElements;
import utils.Const;

import static com.codeborne.selenide.Selenide.*;
import static logic.MainPageLogic.closeTour;

public class AdvancedToolsLogic extends BaseLogic {


    public void advancedToolsFunctionalityVerification() {
        // Step 1. Proceed to 'AdvancedApps' section.
        closeTour();

        MainPageElements.myAccount.hover();
        MainPageElements.advancedToolsButton.click();

        // Result: Advanced Tools section should open without issues.
        AdvancedToolsElements.appletApps.shouldBe(Condition.visible);

        // Step 2. Click domain drop-down.
        AdvancedToolsElements.appletApps.hover();
        AdvancedToolsElements.domainSelector.click();

        // Result: Domain drop-down is shown
        AdvancedToolsElements.domainsExpanded.shouldBe(Condition.visible);

        // Click the first domain in the dropdown
        String firstDomain = AdvancedToolsElements.firstDomainInDropdown.getText();
        AdvancedToolsElements.firstDomainInDropdown.click();
        Selenide.sleep(Const.NORMAL_SLEEP);
        // Result: Selected domain should be changed
        AdvancedToolsElements.domainSelector.shouldHave(Condition.text(firstDomain));

        // Step 3. Click the Show More button
        int initialHeight = AdvancedToolsElements.appletApps.getSize().getHeight();
        AdvancedToolsElements.showMoreButton.click();
        int increasedHeight = AdvancedToolsElements.appletApps.getSize().getHeight();
        if (increasedHeight <= initialHeight) {
            throw new AssertionError("The height of the element has not increased.");
        }

        Selenide.sleep(Const.NORMAL_SLEEP);

        AdvancedToolsElements.showLessButton.click();
        Selenide.sleep(Const.NORMAL_SLEEP);
        int currentHeight = AdvancedToolsElements.appletApps.getSize().getHeight();

        if (currentHeight != initialHeight) {
            throw new AssertionError("The height of the element has not decreased.");
        }

    }

    public void appsLaunchVerification() {
        // Step 1. Proceed to 'AdvancedApps' section.
        closeTour();

        MainPageElements.myAccount.hover();
        MainPageElements.advancedToolsButton.click();
        // Result: Advanced Tools section should open without issues.
        AdvancedToolsElements.appletApps.shouldBe(Condition.visible);
        Selenide.sleep(Const.NORMAL_SLEEP);
        // Find all app elements
        $$(".wsos-app").forEach(app -> {
            // Click on the "Launch" button inside each app
            app.$("button[data-run-wsos-app]").click();

            // Switch to the new window
            switchTo().window(1);
            Selenide.sleep(Const.NORMAL_SLEEP);
            // Close the new window
            closeWindow();

            // Switch back to the main window
            switchTo().window(0);
        });
    }
}
