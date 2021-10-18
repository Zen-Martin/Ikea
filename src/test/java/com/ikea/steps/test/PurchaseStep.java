package com.ikea.steps.test;

import com.ikea.context.ScenarioContext;
import com.ikea.pageObjects.PurchasePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class PurchaseStep implements En {

    public PurchaseStep(
            PurchasePage purchasePage,
            ScenarioContext scenario
    ){

        When("Display of the page *gérer votre commande*, fill the following fields with errors", () -> {
            purchasePage.fillForm();
        });

        Then("An error message is displayed below the order number field", () -> {
            Assert.assertEquals(purchasePage.verifyPurchaseNumberField(),true);
        });

        Then("For the email or phone number field, no error message is displayed", () -> {
            Assert.assertEquals(purchasePage.verifyEmailField(),true);
        });




    }
}
