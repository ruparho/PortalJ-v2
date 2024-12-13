package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ServicesPageElements {
    public static final SelenideElement
            hostingDomainsTable = $("div#hostingsDomains"),
            webBundlesTable = $("div#bundleServices"),
            webBundlesListButton = $("div.groupHeader"),
            webBundlesList = $("div.groupHeader"),
            productAppsTable = $("div#productsApps"),
            expandAllServices = $(By.id("expandAll")),
            collapseAllServices = $(By.id("collapseAll")),
            domainRow = $("div.groupTitle[hosting-plan*=qatest]"), // Element by hosting-plan attribute containing 'qatest' in Hosting & Domains table
            reassignButton = $("[data-domain*='qatest-rp-620'][data-action='reassign']"),
            cancelServiceLink = $("a[data-action='cancelService'].red"),
            servicesForm = $("#accservMainPanel"),
            addDomainInServices = $("a[data-action='addDomain']");


    // Cancel Service widget
    public static final SelenideElement
            returnToServicesButton = $("button[data-action='returnToServices']"),
            cancelServiceTitle = $("#cancelservicewidget h1"),
            supportMessage = $("#messageText");

    // Cancel Reassign widget
    public static final SelenideElement
            returnToServicesFromReassign = $("button.backButton"),
            hostingPlanTitle = $(".planTitle"),
            reassignDomainButton = $("div.reassignButton");

    // Cancel Service Widget
    public static final SelenideElement
            cancelServiceWidget = $("#cancelservicewidget"),
            returnToServicesButtonFromCancelWidget = $(".returnToServiceBurtton"),
            serviceDropdown = $(".portal-select[data-portal-select='Services']"),
            backToServicesButton = $("input[data-action='returnToServices']");


    public static final ElementsCollection
            groupItemDivs = webBundlesTable.$$("div.groupItem"),
            groupHeaders = $$("[data-action='toggleHeader']");

}
