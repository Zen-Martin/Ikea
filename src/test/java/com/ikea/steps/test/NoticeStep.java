package com.ikea.steps.test;

import com.ikea.context.ScenarioContext;
import com.ikea.pageObjects.NoticePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class NoticeStep implements En {

    public NoticeStep(
            NoticePage noticePage,
            ScenarioContext scenario
    ){

        Given("Go to the page notice information page", () -> {
            noticePage.goToNoticePage();
        });

        When("Scroll down and click on the first link of *charte de protection des données*", () -> {
            noticePage.clickOnPrivacyCharter();
        });

        Then("A {int} error page is displayed", (Integer int1) -> {
            Assert.assertEquals(noticePage.verifyAccess(),true);
        });


    }
}
