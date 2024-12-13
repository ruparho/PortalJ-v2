package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class PaymentsPageElements {
    public static final SelenideElement
            paymentsBraintreeForm = $(byId("braintree_paymeths")),
            paymentsForm = $(byId("FormAccountPaymentMethod"));
}
