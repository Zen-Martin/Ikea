package com.ikea.steps.test;

import com.ikea.context.ScenarioContext;
import com.ikea.pageObjects.HomePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class HomeStep implements En {

    public HomeStep(
            HomePage homePage,
            ScenarioContext scenario
    ){

        Given("I am on the homePage", () -> {
            homePage.goToHomePage();
        });

        Given("Click on the truck icon reserved for tracking the order", () -> {
            homePage.clickOnPurchase();
        });

    }

}
