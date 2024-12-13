package logic;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import elements.MainPageElements;
import elements.ServicesPageElements;
import utils.Const;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static logic.MainPageLogic.closeTour;

public class ServicesPageLogic extends BaseLogic {
    public void servicesVerification() {
        // 1. Hover over 'My account' menu icon and proceed to 'Services' page.
        closeTour();

        gotToServices();

        //2.Page should be divided into 3 sections: ' Web Bundles & Services ', 'Hosting & Domains' and 'Products & Applications'.
        ServicesPageElements.hostingDomainsTable.shouldBe(Condition.visible);
        ServicesPageElements.productAppsTable.shouldBe(Condition.visible);
        ServicesPageElements.webBundlesTable.shouldBe(Condition.visible);

        // 6. Click on any application, package or service row.
        ServicesPageElements.webBundlesListButton.click();
        // Result: Row should be expanded.
        ServicesPageElements.webBundlesList.shouldHave(attribute("expanded", ""));
        Selenide.sleep(Const.SHORT_SLEEP);

        // 7. Click on expanded service or package.
        ServicesPageElements.webBundlesListButton.click();
        // Result: Row should be collapsed.
        ServicesPageElements.webBundlesList.shouldNotHave(attribute("expanded"));

        // 8. Click on 'Expand all rows'.
        ServicesPageElements.expandAllServices.click();
        // Result: All rows should be expanded.
        ServicesPageElements.webBundlesList.shouldHave(attribute("expanded", ""));
        Selenide.sleep(Const.SHORT_SLEEP);

        // 9. Click on 'Collapse all rows'.
        ServicesPageElements.collapseAllServices.click();
        ServicesPageElements.webBundlesList.shouldNotHave(attribute("expanded"));
    }

    public void linksVerification() {
        // 1. Hover over 'My account' menu icon and proceed to 'Services' page.
        closeTour();

        gotToServices();

        // 2. Hover mouse over any 'Hosting & Domain's row.
        ServicesPageElements.domainRow.hover();

        Selenide.sleep(Const.LONG_SLEEP);
        // Result: 'Add Domain' or 'Reassign Domain' button should appear.
        ServicesPageElements.reassignButton.shouldBe(visible);

        // 3. Click on 'Cancel Service'
        ServicesPageElements.cancelServiceLink.click();
        Selenide.sleep(Const.NORMAL_SLEEP);
        // Result: User should proceed to cancellation page.
        ServicesPageElements.cancelServiceTitle.shouldBe(visible);
        ServicesPageElements.supportMessage.shouldBe(visible);
        ServicesPageElements.returnToServicesButton.shouldBe(visible).click();
        Selenide.sleep(Const.NORMAL_SLEEP);

        // 4. Click on 'Add an Existing Domain'.
        ServicesPageElements.addDomainInServices.click();
        Selenide.sleep(Const.NORMAL_SLEEP);
        // Result: Shop is opened
        String currentUrl = getWebDriver().getCurrentUrl();
        assert (currentUrl).contains("shop");
    }

    public void reassignLinkVerification() {
        // 1. Hover over 'My account' menu icon and proceed to 'Services' page.
        closeTour();

        gotToServices();

        // 2. Hover mouse over any 'Hosting & Domain's row.
        ServicesPageElements.domainRow.hover();
        Selenide.sleep(Const.NORMAL_SLEEP);
        // Result: 'Add Domain' or 'Reassign Domain' button should appear.
        ServicesPageElements.reassignButton.shouldBe(visible);
        Selenide.sleep(Const.SHORT_SLEEP);

        // 3. Click on 'Reassign Domain'.
        ServicesPageElements.reassignButton.click();
        Selenide.sleep(Const.LONG_SLEEP);
        // Result: Reassign page is opened
        ServicesPageElements.returnToServicesFromReassign.shouldBe(visible);
        ServicesPageElements.hostingPlanTitle.shouldBe(visible).hover();
        ServicesPageElements.reassignDomainButton.shouldBe(visible);

    }

    public void cancelServiceVerification() {
        // 1. Hover over 'My account' menu icon and proceed to 'Services' page.
        closeTour();

        gotToServices();

        // 2. Click on 'Cancel Service'.
        ServicesPageElements.cancelServiceLink.click();
        // Result: User should proceed to cancellation page.
        ServicesPageElements.cancelServiceWidget.shouldBe(visible);
        ServicesPageElements.returnToServicesButtonFromCancelWidget.shouldBe(visible);
        ServicesPageElements.serviceDropdown.shouldBe(visible);
        ServicesPageElements.backToServicesButton.shouldBe(visible);

        // 3. Click on drop down.
        ServicesPageElements.serviceDropdown.click();
        // Result: List of products/services should be expanded.
        Selenide.sleep(Const.SHORT_SLEEP);
        ServicesPageElements.serviceDropdown.shouldHave(attribute("aria-expanded", "true"));


        // 4. Click on 'Back to Service' button.
        ServicesPageElements.serviceDropdown.click();
        ServicesPageElements.serviceDropdown.shouldHave(attribute("aria-expanded", "false"));

        ServicesPageElements.backToServicesButton.click();
        // Result: Services Page Should be opened
        ServicesPageElements.hostingDomainsTable.shouldBe(Condition.visible);
        ServicesPageElements.productAppsTable.shouldBe(Condition.visible);
        ServicesPageElements.webBundlesTable.shouldBe(Condition.visible);
    }


    public void gotToServices() {
        Selenide.sleep(Const.LONG_SLEEP);
        MainPageElements.myAccount.hover();
        MainPageElements.servicesButton.click();
        Selenide.sleep(Const.LONG_SLEEP);
    }
}
