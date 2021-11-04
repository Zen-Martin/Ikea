package com.ikea.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {

    @FindBy(id = "onetrust-close-btn-container")
    private WebElement cookieOption;

    @FindBy(css = "div.hnf-header__container.hnf-page-container__main > ul li a")
    private List<WebElement> NavBarOption;

    public HomePage() {
    }

    public void handleCookie(){
        try{
            shortUntil(visibilityOf(cookieOption));
            clickOn(cookieOption);
        }catch (Exception e){}
    }

    public void goToHomePage(){
        get(config.getEnvironment());
        handleCookie();
    }

    private void clickOnNavBarItem( String elementNavigation){
        WebElement button = NavBarOption
                .stream()
                .filter( elt -> elt.getAttribute("title").equals(elementNavigation))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Not element Found !"));

        clickOn(button);
        waitForLoadingPage();
    }

    public void clickOnPurchase(){
        clickOnNavBarItem("Suivi de commande");
    }

    public void clickOnAccount(){
        clickOnNavBarItem("Mon profil");
    }


}
