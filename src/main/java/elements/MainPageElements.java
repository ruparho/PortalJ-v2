package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageElements {
    /*** Main Page Elements ***/
    public static final SelenideElement
            faxIcon = $("a[title='Online Fax']"),
            webmailIcon = $("a[title='Webmail']"),
            supprotIcon = $("div[title='Support']"),
            takeTourButton = $("button.btn.btn-success.textEllipsis"),
            supportOverlay = $("div.supportInfo h4"),
            footer = $(".footer-tr"),
            addAnEmailLink = $("a[data-button-id='addemail']"),
            advancedToolsLink = $("a[data-button-id='apps']"),
            createWebsiteLink = $("a[data-button-id='websites']"),
            mainLogo = $("#mainTaskBarLogo"),
            recentlyUsedAppsBlock = $(By.id("recentAppsBlock")),
            fileManagerQuickLaunch = $("[data-apptile='filemanager'] button.btn-success"),
            mailManagerQuickLaunch = $("[data-apptile='mailsetup'] button.btn-success"),
            slideWidget = $(By.id("widget_slideproducts")),
            acceptCookies = $("[id='onetrust-accept-btn-handler']"),
            loadingBlocking = $(By.id("loadingblocking"));

    /*** Take a tour(TAT) Elements ***/
    public static final SelenideElement
            tourCloseButton = $("#overlayClose"),
            tourHeader = $("#overlayContent .popup-header span"),
            tourBody = $("#overlayContent .popup-body"),
            tourNoThanksButton = $("#closeTourBlock"),
            tourDontShowAgainCheckbox = $("#dontShowAgainBtn"),
            tourStartTourButton = $("button.btnStartTour"),
            tourMessage = $(".tour-message.bottom-index"),
            tourMessageTitle = $(".ms-tittle-text"),
            tourMessageContent = $(".ms-cont"),
            tourNextButton = $(".message-btn-next"),
            tourPrevButton = $(".message-btn-prev"),
            tourCloseIcon = $("span.close"),
            tourFinishButton = $("input.btn.btn-primary.message-btn-next[value='Finish']"),
            dimmerElement = $("#dimmer");               // an element in which display value is responsible for the lighting of the page during Take a Tour

    //FAX Page
    public static final SelenideElement
            faxLogo = $("img[alt='OnlineFax logo']"),
            faxLoginForm = $("#login-form");


    //Webmail Page
    public static final SelenideElement
            webmailLogo = $("img[alt='Webmail 7.0']"),
            webmailLoginForm = $("form[role='form']");

    // Quick Access
    public static final SelenideElement
            mailManagerFrame = $(By.id("mailsetup_app")),
            websitesPage = $(By.id("applet_websites")),
            advancedToolsPage = $(By.id("applet_apps"));

    // Advanced Tools apps
    public static final SelenideElement
            fileManagerLaunchButton = $("button[data-run-wsos-app='filemanager_nomad']"),
            fileManagerFrame = $(By.id("filemanager_app"));

    //DropDownMenu
    public static final SelenideElement
            usersButton = $(".taskBarButton.userInfo.drop-down .content a.button[data-trackonclick='topbar_am_Users']"),
            servicesButton = $(".taskBarButton.userInfo.drop-down .content a.button[data-trackonclick='topbar_am_Services']"),
            invoicesButton = $(".taskBarButton.userInfo.drop-down .content a.button[data-trackonclick='topbar_am_Invoices']"),
            advancedToolsButton = $(".taskBarButton.userInfo.drop-down .content a.button[data-trackonclick='topbar_am_Advanced Tools']"),
            generalButton = $(".taskBarButton.userInfo.drop-down .content a.button[data-trackonclick='topbar_am_General']"),
            paymentsButton1 = $(".taskBarButton.userInfo.drop-down .content a.button[data-trackonclick='topbar_am_Payments']"),
            paymentsButton2 = $$(By.xpath("//a[@data-trackonclick='topbar_am_Payments']")).get(1),
            logoutLink = $(".taskBarButton.userInfo.drop-down .content a#logoutLink"),
            myAccount = $(".taskBarButton.userInfo.drop-down .title.username[title='My Account']");

    public static final SelenideElement generalForm = $(byId("FormAccountDetails"));
}


