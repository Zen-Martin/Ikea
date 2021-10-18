package com.ikea.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NoticePage extends Page {

    @FindBy(css = "div.c1lpg3h5.i1ycpxq9.pub__designSystemText.t91kxqv.w1fdzi2f p:nth-child(17) > a:nth-child(1)")
    private WebElement privacyDataProtection;

    @FindBy(tagName = "h1")
    private WebElement title;

    private final String URI = config.getEnvironment()+"customer-service/terms-conditions" +
            "/notice-information-pube5bf2231#4c553ab0-70e0-11e9-81cd-7fc84cc44fa0";

    public NoticePage(){}

    public void goToNoticePage(){
        get(URI);
        waitForLoadingPage();
    }

    public void clickOnPrivacyCharter(){
        scroll(privacyDataProtection.getLocation().getY()+10);
        clickOn(privacyDataProtection);
        waitForLoadingPage();
    }

    public boolean verifyAccess(){
        return !title.getText().contains("Page not found");
    }
}
