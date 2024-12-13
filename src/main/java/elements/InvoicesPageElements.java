package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class InvoicesPageElements {
    public static final SelenideElement
            invoicesForm = $(byId("LoginForm"));
}
