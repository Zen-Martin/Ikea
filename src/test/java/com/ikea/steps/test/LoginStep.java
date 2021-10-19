package com.ikea.steps.test;

import com.ikea.context.ScenarioContext;
import com.ikea.pageObjects.LoginPage;
import io.cucumber.java.bs.A;
import io.cucumber.java8.En;
import org.testng.Assert;

public class LoginStep implements En {

    public LoginStep(
            LoginPage loginPage,
            ScenarioContext scenario
    ){

        And("I connect to my account", () -> {
            loginPage.getLogged();
        });

        When("Select an article", () -> {
            loginPage.selectArticle();
        });

        When("Add it to your favorites", () -> {
            loginPage.setOnFavourite();
        });

        Then("The pop-in message of confirmation is in English", () -> {
            Assert.assertEquals(loginPage.verifyFavorisNotification(),true);
        });

        When("Browse theses differents tabs *the profile*, *transactions* and *members links*", () -> {
            loginPage.getOnProfile();
            loginPage.getOnTransaction();
            loginPage.getOnMembres();
        });

        Then("We observe that in the different tabs some texts are in English", () -> {
            Assert.assertEquals(loginPage.verifyTabsLangages(),true);
        });

    }

}
