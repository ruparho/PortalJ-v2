package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class AdvancedToolsElements {
    public static final SelenideElement
            appletApps = $("#applet_apps"),
            domainSelector = $("div.portal-select.noTextSelect[data-portal-select='Domains']"),
            domainsExpanded = $("div[data-type='scroll-block'].scroll-block"),
            firstDomainInDropdown = domainsExpanded.$("div[role='option']"),
            showMoreButton = $("div[data-show-more='Show more']"),
            advancedToolsForm = $(byId("block_wsosApps")),
            showLessButton = $("div[data-show-less='Show less']");

}
